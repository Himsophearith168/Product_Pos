package com.example.posproduct.Service;

import com.example.posproduct.DTO.ProductRequest;
import com.example.posproduct.DTO.ProductResponse;
import com.example.posproduct.Mapper.ProductMapper;
import com.example.posproduct.Model.Category;
import com.example.posproduct.Model.Product;
import com.example.posproduct.Repository.CategoryRepository;
import com.example.posproduct.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    private final String uploadDir = "uploads/products/";

    public ProductResponse createProduct(ProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + request.getCategoryId()));

        Product product = productMapper.toEntity(request, category);
        
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            String imageName = saveImage(request.getImage());
            product.setImage(imageName);
        }

        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return productMapper.toResponse(product);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + request.getCategoryId()));

        productMapper.updateEntity(product, request, category);

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            // Optional: delete old image
            String imageName = saveImage(request.getImage());
            product.setImage(imageName);
        }

        Product updatedProduct = productRepository.save(product);
        return productMapper.toResponse(updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    private String saveImage(MultipartFile file) {
        try {
            Path path = Paths.get(uploadDir);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path filePath = path.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Could not save image: " + e.getMessage());
        }
    }
}

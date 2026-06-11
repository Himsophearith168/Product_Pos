package com.example.posproduct.Mapper;

import com.example.posproduct.DTO.ProductRequest;
import com.example.posproduct.DTO.ProductResponse;
import com.example.posproduct.Model.Category;
import com.example.posproduct.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request, Category category) {
        if (request == null) return null;
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .image(request.getImage())
                .category(category)
                .build();
    }

    public ProductResponse toResponse(Product product) {
        if (product == null) return null;
        ProductResponse response = new ProductResponse();
        response.setProduct_id(product.getProduct_id());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setQuantity(product.getQuantity());
        response.setImage(product.getImage());
        if (product.getCategory() != null) {
            response.setCategoryId(product.getCategory().getId());
        }
        return response;
    }

    public void updateEntity(Product product, ProductRequest request, Category category) {
        if (product == null || request == null) return;
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setImage(request.getImage());
        product.setCategory(category);
    }
}

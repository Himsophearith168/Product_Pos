package com.example.posproduct.Controller;

import com.example.posproduct.DTO.ProductRequest;
import com.example.posproduct.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductRequest> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<ProductRequest> createProduct(@RequestBody ProductRequest productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }
}

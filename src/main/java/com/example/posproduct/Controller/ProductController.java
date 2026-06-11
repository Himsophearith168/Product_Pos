package com.example.posproduct.Controller;

import com.example.posproduct.DTO.ProductRequest;
import com.example.posproduct.DTO.ProductResponse;
import com.example.posproduct.Service.ProductService;
import com.example.posproduct.Util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<APIResponse<ProductResponse>> createProduct(@RequestBody ProductRequest request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                APIResponse.<ProductResponse>builder()
                        .status(HttpStatus.CREATED.value())
                        .message("Product created successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<ProductResponse>>> getAllProducts() {
        List<ProductResponse> responses = productService.getAllProducts();
        return ResponseEntity.ok(
                APIResponse.<List<ProductResponse>>builder()
                        .status(HttpStatus.OK.value())
                        .message("Products retrieved successfully")
                        .data(responses)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ProductResponse>> getProductById(@PathVariable Long id) {
        ProductResponse response = productService.getProductById(id);
        return ResponseEntity.ok(
                APIResponse.<ProductResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Product retrieved successfully")
                        .data(response)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<ProductResponse>> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        ProductResponse response = productService.updateProduct(id, request);
        return ResponseEntity.ok(
                APIResponse.<ProductResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Product updated successfully")
                        .data(response)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(
                APIResponse.<Void>builder()
                        .status(HttpStatus.OK.value())
                        .message("Product deleted successfully")
                        .build()
        );
    }
}

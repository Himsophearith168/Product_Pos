package com.example.posproduct.Controller;

import com.example.posproduct.DTO.CategoryRequest;
import com.example.posproduct.DTO.CategoryResponse;
import com.example.posproduct.Service.CategoryService;
import com.example.posproduct.Util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<APIResponse<CategoryResponse>> createCategory(@RequestBody CategoryRequest request) {
        CategoryResponse response = categoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                APIResponse.<CategoryResponse>builder()
                        .status(HttpStatus.CREATED.value())
                        .message("Category created successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<CategoryResponse>>> getAllCategories() {
        List<CategoryResponse> responses = categoryService.getAllCategories();
        return ResponseEntity.ok(
                APIResponse.<List<CategoryResponse>>builder()
                        .status(HttpStatus.OK.value())
                        .message("Categories retrieved successfully")
                        .data(responses)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<CategoryResponse>> getCategoryById(@PathVariable Long id) {
        CategoryResponse response = categoryService.getCategoryById(id);
        return ResponseEntity.ok(
                APIResponse.<CategoryResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Category retrieved successfully")
                        .data(response)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<CategoryResponse>> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request) {
        CategoryResponse response = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(
                APIResponse.<CategoryResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Category updated successfully")
                        .data(response)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(
                APIResponse.<Void>builder()
                        .status(HttpStatus.OK.value())
                        .message("Category deleted successfully")
                        .build()
        );
    }
}

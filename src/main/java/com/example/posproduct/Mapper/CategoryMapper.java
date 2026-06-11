package com.example.posproduct.Mapper;

import com.example.posproduct.DTO.CategoryRequest;
import com.example.posproduct.DTO.CategoryResponse;
import com.example.posproduct.Model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest request) {
        if (request == null) return null;
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());
        return category;
    }

    public CategoryResponse toResponse(Category category) {
        if (category == null) return null;
        CategoryResponse response = new CategoryResponse();
        response.setCategoryId(category.getId());
        response.setCategoryName(category.getCategoryName());
        response.setDescription(category.getDescription());
        return response;
    }
    
    public void updateEntity(Category category, CategoryRequest request) {
        if (request == null || category == null) return;
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());
    }
}

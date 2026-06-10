package com.example.posproduct.Service;

import com.example.posproduct.DTO.CategoryRequest;
import com.example.posproduct.Model.Category;
import com.example.posproduct.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryRequest> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryRequest(category.getId(), category.getCategoryName(), category.getDescription()))
                .collect(Collectors.toList());
    }

    public CategoryRequest createCategory(CategoryRequest categoryDTO) {
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setDescription(categoryDTO.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return new CategoryRequest(savedCategory.getId(), savedCategory.getCategoryName(), savedCategory.getDescription());
    }
}

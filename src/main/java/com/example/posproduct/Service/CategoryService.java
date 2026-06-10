package com.example.posproduct.Service;

import com.example.posproduct.DTO.CategoryDTO;
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

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDTO(category.getId(), category.getCategoryName(), category.getDescription()))
                .collect(Collectors.toList());
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setDescription(categoryDTO.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return new CategoryDTO(savedCategory.getId(), savedCategory.getCategoryName(), savedCategory.getDescription());
    }
}

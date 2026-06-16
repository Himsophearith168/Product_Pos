package com.example.posproduct.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotEmpty(message = "Name is Require")
    private String name;
    private String description;
    @NotNull(message = "Price are Require")
    private Double price;
    @NotNull(message = "Quantity are Require")
    private Integer quantity;
    @NotNull(message = "Image of Product are require")
    private MultipartFile image;
    @NotNull(message = "Category ID is Require")
    private Long categoryId;
}

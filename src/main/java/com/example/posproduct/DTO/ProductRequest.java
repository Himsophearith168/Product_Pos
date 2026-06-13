package com.example.posproduct.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private MultipartFile image;
    private Long categoryId;
}

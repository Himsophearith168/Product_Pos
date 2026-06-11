package com.example.posproduct.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long product_id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String image;
    private Long categoryId;
}

package com.example.posproduct.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailRequest {
    @NotNull(message = "Product ID is Require")
    private Long productId;
    @NotNull(message = "Quantity is not null")
    private Integer quantity;
    private String description;
}

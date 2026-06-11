package com.example.posproduct.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrderRequest {
    private Long userId;
    private Double amount;
    private List<OrderDetailRequest> items;
}

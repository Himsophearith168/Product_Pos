package com.example.posproduct.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private LocalDateTime orderDate;
    private Double amount;
    private Long userId;
    private List<OrderDetailResponse> items;
}

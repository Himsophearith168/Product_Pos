package com.example.posproduct.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrderRequest {
    @NotNull(message = "userID is Require")
    private Long userId;
    @NotNull(message = "The Amount is Not Null")
    private Double amount;
    private List<OrderDetailRequest> items;
}

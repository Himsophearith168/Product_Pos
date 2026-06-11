package com.example.posproduct.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private Long orderId;
    private Long userId;
    private Double amount;
    private String remark;
}

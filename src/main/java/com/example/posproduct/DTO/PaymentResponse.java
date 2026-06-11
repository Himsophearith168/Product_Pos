package com.example.posproduct.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    private Long id;
    private Long orderId;
    private Double amount;
    private String remark;
}

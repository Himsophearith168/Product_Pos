package com.example.posproduct.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    @NotNull(message = "OrderID is Require")
    private Long orderId;
    @NotNull(message = "UserID is Require")
    private Long userId;
    @NotNull(message = "The Amount is Not Null")
    private Double amount;
    private String remark;
}

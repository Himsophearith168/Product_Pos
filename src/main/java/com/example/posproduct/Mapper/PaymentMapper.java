package com.example.posproduct.Mapper;

import com.example.posproduct.DTO.PaymentResponse;
import com.example.posproduct.Model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentResponse toResponse(Payment payment) {
        if (payment == null) return null;
        return PaymentResponse.builder()
                .id(payment.getId())
                .orderId(payment.getOrder() != null ? payment.getOrder().getId() : null)
                .amount(payment.getAmount())
                .remark(payment.getRemark())
                .build();
    }
}

package com.example.posproduct.Mapper;

import com.example.posproduct.DTO.OrderResponse;
import com.example.posproduct.Model.Oder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderDetailMapper orderDetailMapper;

    public OrderResponse toResponse(Oder order) {
        if (order == null) return null;
        return OrderResponse.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .amount(order.getAmount())
                .userId(order.getUser() != null ? order.getUser().getUser_id() : null)
                .items(order.getOrderDetails() != null ? 
                    order.getOrderDetails().stream()
                        .map(orderDetailMapper::toResponse)
                        .collect(Collectors.toList()) : null)
                .build();
    }
}

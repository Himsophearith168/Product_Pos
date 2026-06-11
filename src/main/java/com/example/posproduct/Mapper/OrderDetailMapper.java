package com.example.posproduct.Mapper;

import com.example.posproduct.DTO.OrderDetailRequest;
import com.example.posproduct.DTO.OrderDetailResponse;
import com.example.posproduct.Model.Oder;
import com.example.posproduct.Model.OrderDetail;
import com.example.posproduct.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {

    public OrderDetail toEntity(OrderDetailRequest request, Oder order, Product product) {
        if (request == null) return null;
        return OrderDetail.builder()
                .order(order)
                .product(product)
                .quantity(request.getQuantity())
                .description(request.getDescription())
                .build();
    }

    public OrderDetailResponse toResponse(OrderDetail detail) {
        if (detail == null) return null;
        return OrderDetailResponse.builder()
                .id(detail.getId())
                .productId(detail.getProduct() != null ? detail.getProduct().getProduct_id() : null)
                .productName(detail.getProduct() != null ? detail.getProduct().getName() : null)
                .quantity(detail.getQuantity())
                .description(detail.getDescription())
                .build();
    }
}

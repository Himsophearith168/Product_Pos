package com.example.posproduct.Service;

import com.example.posproduct.DTO.OrderDetailResponse;
import com.example.posproduct.Mapper.OrderDetailMapper;
import com.example.posproduct.Repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;

    public List<OrderDetailResponse> getAllOrderDetails() {
        return orderDetailRepository.findAll().stream()
                .map(orderDetailMapper::toResponse)
                .collect(Collectors.toList());
    }
}

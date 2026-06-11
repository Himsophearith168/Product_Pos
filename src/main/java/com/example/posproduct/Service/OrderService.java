package com.example.posproduct.Service;

import com.example.posproduct.DTO.OrderDetailRequest;
import com.example.posproduct.DTO.OrderRequest;
import com.example.posproduct.DTO.OrderResponse;
import com.example.posproduct.Mapper.OrderDetailMapper;
import com.example.posproduct.Mapper.OrderMapper;
import com.example.posproduct.Model.Oder;
import com.example.posproduct.Model.OrderDetail;
import com.example.posproduct.Model.Product;
import com.example.posproduct.Model.User;
import com.example.posproduct.Repository.OrderDetailRepository;
import com.example.posproduct.Repository.OrderRepository;
import com.example.posproduct.Repository.ProductRepository;
import com.example.posproduct.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Oder order = Oder.builder()
                .user(user)
                .amount(request.getAmount())
                .orderDate(LocalDateTime.now())
                .orderTime(LocalDateTime.now())
                .orderDetails(new ArrayList<>())
                .build();

        Oder savedOrder = orderRepository.save(order);

        List<OrderDetail> details = request.getItems().stream().map(itemRequest -> {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found: " + itemRequest.getProductId()));
            
            if (product.getQuantity() < itemRequest.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }
            
            product.setQuantity(product.getQuantity() - itemRequest.getQuantity());
            productRepository.save(product);

            return orderDetailMapper.toEntity(itemRequest, savedOrder, product);
        }).collect(Collectors.toList());

        orderDetailRepository.saveAll(details);
        savedOrder.setOrderDetails(details);

        return orderMapper.toResponse(savedOrder);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse getOrderById(Long id) {
        Oder order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toResponse(order);
    }
}

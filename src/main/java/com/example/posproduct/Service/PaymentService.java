package com.example.posproduct.Service;

import com.example.posproduct.DTO.PaymentRequest;
import com.example.posproduct.DTO.PaymentResponse;
import com.example.posproduct.Mapper.PaymentMapper;
import com.example.posproduct.Model.Oder;
import com.example.posproduct.Model.Payment;
import com.example.posproduct.Model.User;
import com.example.posproduct.Repository.OrderRepository;
import com.example.posproduct.Repository.PaymentRepository;
import com.example.posproduct.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final PaymentMapper paymentMapper;

    public PaymentResponse createPayment(PaymentRequest request) {
        Oder order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Payment payment = Payment.builder()
                .order(order)
                .user(user)
                .amount(request.getAmount())
                .remark(request.getRemark())
                .build();

        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toResponse(savedPayment);
    }

    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toResponse)
                .collect(Collectors.toList());
    }
}

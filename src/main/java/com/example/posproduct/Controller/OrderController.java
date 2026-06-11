package com.example.posproduct.Controller;

import com.example.posproduct.DTO.OrderRequest;
import com.example.posproduct.DTO.OrderResponse;
import com.example.posproduct.Service.OrderService;
import com.example.posproduct.Util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<APIResponse<OrderResponse>> createOrder(@RequestBody OrderRequest request) {
        OrderResponse response = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                APIResponse.<OrderResponse>builder()
                        .status(HttpStatus.CREATED.value())
                        .message("Order created successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<OrderResponse>>> getAllOrders() {
        List<OrderResponse> responses = orderService.getAllOrders();
        return ResponseEntity.ok(
                APIResponse.<List<OrderResponse>>builder()
                        .status(HttpStatus.OK.value())
                        .message("Orders retrieved successfully")
                        .data(responses)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<OrderResponse>> getOrderById(@PathVariable Long id) {
        OrderResponse response = orderService.getOrderById(id);
        return ResponseEntity.ok(
                APIResponse.<OrderResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Order retrieved successfully")
                        .data(response)
                        .build()
        );
    }
}

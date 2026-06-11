package com.example.posproduct.Controller;

import com.example.posproduct.DTO.OrderDetailResponse;
import com.example.posproduct.Service.OrderDetailService;
import com.example.posproduct.Util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<APIResponse<List<OrderDetailResponse>>> getAllOrderDetails() {
        List<OrderDetailResponse> responses = orderDetailService.getAllOrderDetails();
        return ResponseEntity.ok(
                APIResponse.<List<OrderDetailResponse>>builder()
                        .status(HttpStatus.OK.value())
                        .message("Order details retrieved successfully")
                        .data(responses)
                        .build()
        );
    }
}

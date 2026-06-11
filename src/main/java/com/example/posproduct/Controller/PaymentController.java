package com.example.posproduct.Controller;

import com.example.posproduct.DTO.PaymentRequest;
import com.example.posproduct.DTO.PaymentResponse;
import com.example.posproduct.Service.PaymentService;
import com.example.posproduct.Util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<APIResponse<PaymentResponse>> createPayment(@RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.createPayment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                APIResponse.<PaymentResponse>builder()
                        .status(HttpStatus.CREATED.value())
                        .message("Payment processed successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<PaymentResponse>>> getAllPayments() {
        List<PaymentResponse> responses = paymentService.getAllPayments();
        return ResponseEntity.ok(
                APIResponse.<List<PaymentResponse>>builder()
                        .status(HttpStatus.OK.value())
                        .message("Payments retrieved successfully")
                        .data(responses)
                        .build()
        );
    }
}

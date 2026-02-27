package com.mercadopreso.payment.gateways;


import com.mercadopreso.payment.domains.Payment;
import com.mercadopreso.payment.gateways.dtos.PaymentDto;
import com.mercadopreso.payment.gateways.dtos.response.PaymentResponseDto;
import com.mercadopreso.payment.services.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping()
    public ResponseEntity<PaymentResponseDto> create(@RequestBody @Valid PaymentDto paymentDto) {
        Payment payment = paymentService.executePayment(paymentDto.toPayment());
        return ResponseEntity.status(HttpStatus.CREATED).body(PaymentResponseDto.fromPayment(payment));
    }
}

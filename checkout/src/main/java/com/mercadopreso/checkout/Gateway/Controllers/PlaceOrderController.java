package com.mercadopreso.checkout.Gateway.Controllers;

import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.PlaceOrderRequestDto;
import com.mercadopreso.checkout.Services.PlaceOrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/fazerPedido")
public class PlaceOrderController {
    private final PlaceOrderService placeOrderService;

    @PostMapping
    public ResponseEntity<Void> placeOrder(@RequestBody @Valid PlaceOrderRequestDto placeOrderRequestDto) {
        placeOrderService.placeOrder(placeOrderRequestDto.getCart(), placeOrderRequestDto.getPayment());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

package com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentDto {
    @NotNull(message = "paymentId é obrigatório")
    private String id;

    @NotNull(message = "type é obrigatório")
    private String type;

    @NotNull(message = "hashId é obrigatório")
    private String hashId;

    @NotNull(message = "gateway é obrigatório")
    private String gateway;
}

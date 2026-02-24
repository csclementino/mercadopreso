package com.mercadopreso.payment.gateways.dtos.response;

import com.mercadopreso.payment.domains.Payment;
import com.mercadopreso.payment.domains.enums.Gateway;
import com.mercadopreso.payment.domains.enums.Status;
import com.mercadopreso.payment.domains.enums.Type;

public record PaymentResponseDto(
        Type type,
        String hashId,
        Gateway gateway,
        Status status,
        Double amount
) {

    public static PaymentResponseDto fromPayment(Payment payment) {
        return new PaymentResponseDto(
                payment.getType(),
                payment.getHashId(),
                payment.getGateway(),
                payment.getStatus(),
                payment.getAmount()
        );
    }
}

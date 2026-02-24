package com.mercadopreso.payment.services;


import com.mercadopreso.payment.domains.Payment;
import com.mercadopreso.payment.domains.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private Status gerarStatusAleatorio() {
        Status[] statuses = Status.values();
        int index = ThreadLocalRandom.current().nextInt(statuses.length);
        return statuses[index];
    }

    public Payment executePayment(Payment payment) {

        String hash = UUID.randomUUID().toString().replace("-", "");

        return Payment.builder()
                .id(UUID.randomUUID().toString())
                .type(payment.getType())
                .hashId(hash)
                .gateway(payment.getGateway())
                .status(gerarStatusAleatorio())
                .amount(payment.getAmount())
                .build();

    }

}

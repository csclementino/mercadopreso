package com.mercadopreso.payment.services;


import com.mercadopreso.payment.domains.Payment;
import com.mercadopreso.payment.domains.enums.Gateway;
import com.mercadopreso.payment.domains.enums.Status;
import com.mercadopreso.payment.domains.enums.Type;
import com.mercadopreso.payment.gateways.client.QuoteClient;
import com.mercadopreso.payment.gateways.dtos.response.QuoteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final QuoteClient quoteClient;

    private Status randomStatus() {
        Status[] statuses = Status.values();
        int index = ThreadLocalRandom.current().nextInt(statuses.length);
        return statuses[index];
    }

    private Gateway randomGateway() {
        Gateway[] gateways = Gateway.values();
        int index = ThreadLocalRandom.current().nextInt(gateways.length);
        return gateways[index];
    }

    private Type randomType() {
        Type[] types = Type.values();
        int index = ThreadLocalRandom.current().nextInt(types.length);
        return types[index];
    }

    public Payment executePayment(Payment payment) {

        BigDecimal amount = payment.getAmount();
        Gateway gateway = randomGateway();

        switch (gateway) {
            case Gateway.PAYPAL -> {
                    Map<String, QuoteResponseDto> response = quoteClient.quoteRequest("USD-BRL");
                    QuoteResponseDto usd = response.get("USDBRL");
                    BigDecimal quote = new BigDecimal(usd.bid().replace(",", "."));
                    amount = payment.getAmount().divide(quote, 2, RoundingMode.HALF_UP);
                }
            case Gateway.STRIPE -> {
                Map<String, QuoteResponseDto> response = quoteClient.quoteRequest("EUR-BRL");
                QuoteResponseDto eur = response.get("EURBRL");
                BigDecimal quote = new BigDecimal(eur.bid().replace(",", "."));
                amount = payment.getAmount().divide(quote, 2, RoundingMode.HALF_UP);
            }
            default ->  {
            }

        }

        return Payment.builder()
                .id(UUID.randomUUID().toString())
                .type(randomType())
                .hashId(payment.getHashId())
                .gateway(gateway)
                .status(randomStatus())
                .amount(amount)
                .build();

    }

}

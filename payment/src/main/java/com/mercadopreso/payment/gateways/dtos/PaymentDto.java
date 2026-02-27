package com.mercadopreso.payment.gateways.dtos;
import com.mercadopreso.payment.domains.Payment;
import com.mercadopreso.payment.domains.enums.Gateway;
import com.mercadopreso.payment.domains.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PaymentDto {

    @NotNull(message = "Tipo do pagamento é obrigatório, Tipos de pagamentos aceitos: CARTAO_CREDITO,CARTAO_DEBITO,PIX,BOLETO,TRANSFERENCIA,CARTEIRA_DIGITAL")
    private Type type;

    @NotBlank(message = "Usuário é obrigatório")
    private String userId;

    @NotNull(message = "Gateway é obrigatório, Tipos de gateways aceitos: STRIPE,MERCADO_PAGO,PAGSEGURO,PAYPAL,CIELO,REDE")
    private Gateway gateway;

    @NotNull(message = "Valor é obrigatório")
    @Positive(message = "Valor deve ser maior que zero")
    private Double amount;

    public Payment toPayment() {
        return Payment.builder()
                .type(type)
                .userId(userId)
                .gateway(gateway)
                .amount(amount)
                .build();
    }
}

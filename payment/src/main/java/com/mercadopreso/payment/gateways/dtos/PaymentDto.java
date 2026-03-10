package com.mercadopreso.payment.gateways.dtos;
import com.mercadopreso.payment.domains.Payment;
import com.mercadopreso.payment.domains.enums.Gateway;
import com.mercadopreso.payment.domains.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDto {

    @NotBlank(message = "HashId é obrigatório")
    @Pattern(
            regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$",
            message = "O campo deve ser um UUID válido"
    )
    private String hashId;

    @NotNull(message = "Valor é obrigatório")
    @Positive(message = "Valor deve ser maior que zero")
    private BigDecimal amount;

    public Payment toPayment() {
        return Payment.builder()
                .hashId(hashId)
                .amount(amount)
                .build();
    }
}

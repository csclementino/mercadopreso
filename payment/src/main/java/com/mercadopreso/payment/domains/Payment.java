package com.mercadopreso.payment.domains;

import com.mercadopreso.payment.domains.enums.Gateway;
import com.mercadopreso.payment.domains.enums.Status;
import com.mercadopreso.payment.domains.enums.Type;
import lombok.*;

@With
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Payment {

    private String id;
    private Type type;
    private String hashId;
    private Gateway gateway;
    private Status status;
    private Double amount;
    private String userId;

}

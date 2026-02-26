package com.mercadopreso.checkout.Domains;

import lombok.*;

import java.math.BigDecimal;

@With
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String id;
    private String sku;
    private BigDecimal price;
}

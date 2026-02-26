package com.mercadopreso.checkout.Domains;


import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@With
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String userId;
    private List<Item> items;
    private BigDecimal finalPrice;
    private String status;
    private String address;
    private String paymentId;
}

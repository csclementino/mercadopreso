package com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto;

import com.mercadopreso.checkout.Domains.Item;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartDto {
    @NotNull(message = "cartId é obrigatório")
    private String cartId;

    @Valid
    @NotEmpty(message = "items não pode ser vazio")
    private List<Item> items;

    @NotNull(message = "userId é obrigatório")
    private String userId;

    private String coupon;

    @NotNull(message = "freight é obrigatório")
    private BigDecimal freight;
}

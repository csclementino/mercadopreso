package com.mercadopreso.checkout.Services;

import com.mercadopreso.checkout.Domains.Item;
import com.mercadopreso.checkout.Domains.Order;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.CartDto;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.PaymentDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class PlaceOrderService {
    public void placeOrder(CartDto cart, PaymentDto payment) {
        String orderId = UUID.randomUUID().toString();
        List<Item> items = cart.getItems();
        BigDecimal itemsTotal = items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = Order.builder()
                .id(orderId)
                .userId(cart.getUserId())
                .items(items)
                .finalPrice(itemsTotal.add(cart.getFreight()))
                .status("CREATED")
                .paymentId(payment.getId())
                .build();

        // TODO persistir pedido e publicar evento para os próximos serviços.
    }
}

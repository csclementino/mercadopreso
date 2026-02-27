package com.mercadopreso.item.service.impl;

import com.mercadopreso.item.dto.ItemDto;
import com.mercadopreso.item.service.ItemService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private static final Map<String, ItemDto> ITEM_STORE = Map.of(
            "item-1", ItemDto.builder()
                    .id("item-1")
                    .name("Notebook")
                    .description("High-performance laptop")
                    .price(new BigDecimal("3999.99"))
                    .availableQuantity(10)
                    .build(),
            "item-2", ItemDto.builder()
                    .id("item-2")
                    .name("Smartphone")
                    .description("Latest model smartphone")
                    .price(new BigDecimal("2499.99"))
                    .availableQuantity(25)
                    .build(),
            "item-3", ItemDto.builder()
                    .id("item-3")
                    .name("Headphones")
                    .description("Wireless noise-cancelling headphones")
                    .price(new BigDecimal("799.99"))
                    .availableQuantity(50)
                    .build()
    );

    @Override
    public List<ItemDto> getItems(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return List.copyOf(ITEM_STORE.values());
        }
        return ids.stream()
                .filter(ITEM_STORE::containsKey)
                .map(ITEM_STORE::get)
                .collect(Collectors.toUnmodifiableList());
    }
}

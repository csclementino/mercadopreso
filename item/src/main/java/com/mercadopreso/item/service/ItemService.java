package com.mercadopreso.item.service;

import com.mercadopreso.item.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getItems(List<String> ids);
}

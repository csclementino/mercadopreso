package com.mercadopreso.item.controller;

import com.mercadopreso.item.dto.ItemDto;
import com.mercadopreso.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDto>> getItems(
            @RequestParam(required = false) List<String> ids) {
        return ResponseEntity.ok(itemService.getItems(ids));
    }
}

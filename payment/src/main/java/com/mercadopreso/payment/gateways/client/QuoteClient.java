package com.mercadopreso.payment.gateways.client;


import com.mercadopreso.payment.gateways.dtos.response.QuoteResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "quote", url = "https://economia.awesomeapi.com.br/json/last")
public interface QuoteClient {

    @GetMapping("/{convert}")
    Map<String, QuoteResponseDto> quoteRequest(@PathVariable String convert);
}

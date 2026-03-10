package com.mercadopreso.payment.gateways.dtos.response;

public record QuoteResponseDto(
        String bid
) {
    public static QuoteResponseDto fromQuote(QuoteResponseDto quoteResponseDto) {
        return new QuoteResponseDto(
                quoteResponseDto.bid()
        );
    }
}

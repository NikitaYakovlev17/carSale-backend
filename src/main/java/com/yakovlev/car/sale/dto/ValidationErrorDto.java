package com.yakovlev.car.sale.dto;

public record ValidationErrorDto(
        String scope,
        String message
) {
}

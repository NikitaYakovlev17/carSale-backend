package com.yakovlev.car.sale.dto;

import com.yakovlev.car.sale.dto.user.RoleRequestDto;

public record LoginResponseDto(
        Long id,
        String email,
        RoleRequestDto role,
        String firstName
) {
}

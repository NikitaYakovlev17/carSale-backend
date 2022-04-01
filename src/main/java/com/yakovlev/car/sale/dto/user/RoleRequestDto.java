package com.yakovlev.car.sale.dto.user;

import javax.validation.constraints.NotBlank;

public record RoleRequestDto(
        @NotBlank(message = "role name cannot be blank")
        String name
) {
}

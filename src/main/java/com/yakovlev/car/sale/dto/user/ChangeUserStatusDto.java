package com.yakovlev.car.sale.dto.user;

import com.yakovlev.car.sale.model.enums.ActivityStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ChangeUserStatusDto(
        @NotBlank(message = "email cannot be blank")
        String email,
        @NotNull(message = "status cannot be blank")
        ActivityStatus status
) {
}

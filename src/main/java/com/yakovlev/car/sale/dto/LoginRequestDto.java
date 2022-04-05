package com.yakovlev.car.sale.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record LoginRequestDto(
        @NotBlank(message = "email cannot be blank")
        @Email(message = "Неверный формат почты")
        String email,

        @NotBlank(message = "password cannot be blank")
        @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$",
                message = "Неверный формат пароля")
        String password
) {
}

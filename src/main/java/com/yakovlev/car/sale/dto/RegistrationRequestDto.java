package com.yakovlev.car.sale.dto;

import com.yakovlev.car.sale.dto.user.RoleRequestDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record RegistrationRequestDto(
        @NotBlank(message = "email не заполнен")
        @Email(message = "Неверный формат почты")
        String email,

        @NotBlank(message = "имя пользователя не заполнено")
        String firstName,

        @NotBlank(message = "номер телефона не заполнен")
        @Pattern(regexp = "^(\\+375|80|375)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$",
                message = "Неверный номер телефона")
        String phoneNumber,

        RoleRequestDto role,

        @NotBlank(message = "пароль не заполнен")
        @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$",
                message = "Пароль должен содержать только латинские буквы и цифры")
        String password
) {
}

package com.yakovlev.car.sale.dto;

import com.yakovlev.car.sale.dto.user.RoleRequestDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record RegistrationRequestDto(
        @NotBlank(message = "email cannot be blank")
        @Email(message = "Неверный формат почты")
        String email,

        @NotBlank(message = "firstName cannot be blank")
        String firstName,

        @NotBlank(message = "phoneNumber cannot be blank")
        String phoneNumber,

        RoleRequestDto role,

        @NotBlank(message = "password cannot be blank")
        @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$",
                message = "Пароль должен содержать только латинские буквы и цифры и быть в промежутке от 8 до 20 симоволов")
        String password
) {
}

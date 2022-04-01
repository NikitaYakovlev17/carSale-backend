package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.RegistrationRequestDto;
import com.yakovlev.car.sale.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    public void register(@RequestBody RegistrationRequestDto user){
        //userService.isUserRegistered(user.email());
        userService.register(user);
        //log.info("User with email {} successfully registered. {}", user.email(), LocalDate.now());
    }
}

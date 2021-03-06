package com.yakovlev.car.sale.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.yakovlev.car.sale.dto.LoginRequestDto;
import com.yakovlev.car.sale.dto.LoginResponseDto;
import com.yakovlev.car.sale.dto.RegistrationRequestDto;
import com.yakovlev.car.sale.dto.user.RoleRequestDto;
import com.yakovlev.car.sale.dto.user.UserDto;
import com.yakovlev.car.sale.jwt.JwtTokenProvider;
import com.yakovlev.car.sale.model.User;
import com.yakovlev.car.sale.model.enums.ActivityStatus;
import com.yakovlev.car.sale.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
public class UserController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto loginRequestDto,
                                  HttpServletResponse response) throws Exception {
        String email = loginRequestDto.email();
        User user = userService.getByEmail(email);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, loginRequestDto.password()));

        if (user.getStatus().equals(ActivityStatus.IN_ACTIVE)) {
            throw new Exception("Ваш аккаунт заблокирован");
        }

        response.addCookie(jwtTokenProvider.getCookieWithAccessToken(user));

        log.info("User with email {} login. {}", email, LocalDate.now());
        return new LoginResponseDto(
                user.getId(),
                user.getEmail(),
                new RoleRequestDto(user.getRole().getName()),
                user.getFirstName(),
                user.getPhoneNumber());
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    public void register(@Valid @RequestBody RegistrationRequestDto user){
        userService.isUserRegistered(user.email());
        userService.register(user);
        log.info("User with email {} successfully registered. {}", user.email(), LocalDate.now());
    }

    @GetMapping(value = "/logout")
    public void logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("access", null);
        cookie.setMaxAge(0);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id){
        return userService.getById(id);
    }


    @PutMapping(value = "/{id}")
    public UserDto updateUserInfo(@Valid @RequestBody UserDto user, @PathVariable Long id) throws Exception {
        UserDto userFromDb = userService.editInfo(id, user);
        log.info("User with id {} successfully edited. {}", id, LocalDate.now());
        return userFromDb;
    }

    @PutMapping(value = "/{id}/password")
    public UserDto updatePassword(@Valid @RequestBody ObjectNode json, @PathVariable Long id) throws Exception {
        UserDto userFromDb = userService.editPassword(id, json.get("password").asText(), json.get("oldPassword").asText());
        log.info("User password with id {} successfully edited. {}", id, LocalDate.now());
        return userFromDb;
    }

    @GetMapping(value = "/{id}/like/{carAdId}")
    public void likeCarAd(@PathVariable Long id, @PathVariable Long carAdId) throws Exception {
        userService.likeCarAd(id, carAdId);
    }

    @GetMapping(value = "/{id}/dislike/{carAdId}")
    public void dislikeCarAd(@PathVariable Long id, @PathVariable Long carAdId){
        userService.dislikeCarAd(id, carAdId);
    }
}

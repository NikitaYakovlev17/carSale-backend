package com.yakovlev.car.sale.jwt;

import com.yakovlev.car.sale.model.User;
import com.yakovlev.car.sale.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getByEmail(email);

        JwtUser jwtUser = JwtUser.fromUser(user);
        log.debug("UserDetailsService - user with email: {} successfully loaded", email);

        return jwtUser;
    }
}

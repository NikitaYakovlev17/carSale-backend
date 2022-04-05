package com.yakovlev.car.sale.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yakovlev.car.sale.model.Role;
import com.yakovlev.car.sale.model.User;
import com.yakovlev.car.sale.model.enums.ActivityStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public record JwtUser(
        Long id,
        String email,
        String password,
        ActivityStatus activityStatus,
        Collection<? extends GrantedAuthority> authorities
) implements UserDetails {
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public static JwtUser fromUser(User user) {
        return new JwtUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus(),
                mapToGrantedAuthorities(List.of(user.getRole()))
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return email;
    }

    @JsonIgnore
    public ActivityStatus getStatus() {
        return activityStatus;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

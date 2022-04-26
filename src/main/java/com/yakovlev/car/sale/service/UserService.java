package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.RegistrationRequestDto;
import com.yakovlev.car.sale.dto.user.UserDto;
import com.yakovlev.car.sale.exception.RegistrationException;
import com.yakovlev.car.sale.mapper.UserMapper;
import com.yakovlev.car.sale.model.User;
import com.yakovlev.car.sale.model.enums.ActivityStatus;
import com.yakovlev.car.sale.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.yakovlev.car.sale.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto getById(Long id){
        return userMapper.toDto(userRepository.getById(id));
    }

    public User getByEmail(String email) throws Exception {
        return this.userRepository.findByEmail(email).orElseThrow(() ->
                new Exception("User with such Email not exists"));
    }

    public UserDto getDtoByEmail(String email) throws Exception {
        return userMapper.toDto(this.userRepository.findByEmail(email).orElseThrow(() ->
                new Exception("User with such Email not exists")));
    }

    public void isUserRegistered(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RegistrationException("User with such email was registered");
        }
    }

    public void register(RegistrationRequestDto userDto){
        this.userRepository.save(
                User.builder()
                        .email(userDto.email())
                        .firstName(userDto.firstName())
                        .phoneNumber(userDto.phoneNumber())
                        .role(this.roleRepository.findByName("USER"))
                        .password(passwordEncoder.encode(userDto.password()))
                        .status(ActivityStatus.ACTIVE)
                        .build()
        );
    }
}

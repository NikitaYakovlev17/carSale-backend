package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.carAd.CarAdDto;
import com.yakovlev.car.sale.mapper.CarAdMapper;
import com.yakovlev.car.sale.repository.CarAdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarAdService {
    private final CarAdRepository carAdRepository;
    private final CarAdMapper carAdMapper;

    public List<CarAdDto> getAll() {
        return carAdMapper.toDto(carAdRepository.findAll());
    }


//    public User getByEmail(String email) throws Exception {
//        return this.userRepository.findByEmail(email).orElseThrow(() ->
//                new Exception("User with such Email not exists"));
//    }
//
//    public UserDto getDtoByEmail(String email) throws Exception {
//        return userMapper.toDto(this.userRepository.findByEmail(email).orElseThrow(() ->
//                new Exception("User with such Email not exists")));
//    }
}

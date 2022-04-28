package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.carAd.CarAdDto;
import com.yakovlev.car.sale.mapper.CarAdMapper;
import com.yakovlev.car.sale.mapper.UserMapper;
import com.yakovlev.car.sale.model.CarAd;
import com.yakovlev.car.sale.model.CarAdPage;
import com.yakovlev.car.sale.model.CarAdSearchCriteria;
import com.yakovlev.car.sale.repository.CarAdCriteriaRepository;
import com.yakovlev.car.sale.repository.CarAdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarAdService {
    private final CarAdRepository carAdRepository;
    private final CarAdCriteriaRepository carAdCriteriaRepository;
    private final CarAdMapper carAdMapper;
    private final UserMapper userMapper;

    public List<CarAdDto> getAll() {
        return carAdMapper.toDto(carAdRepository.findAll());
    }

    public CarAdDto getDtoById(Long id){
        return carAdMapper.toDto(carAdRepository.getById(id));
    }

    public CarAd getById(Long id){
        return carAdRepository.getById(id);
    }

    public List<CarAdDto> getCarAds(CarAdPage carAdPage, CarAdSearchCriteria carAdSearchCriteria){
        Page<CarAd> carAds = carAdCriteriaRepository.findAllWithFilters(carAdPage, carAdSearchCriteria);
        List<CarAdDto> carAdDtos = carAdMapper.toDto(carAds.getContent());
        return carAdDtos;
    }
}

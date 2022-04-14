package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.carAd.CarAdDto;
import com.yakovlev.car.sale.model.CarAd;
import com.yakovlev.car.sale.service.CarAdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/car-ad")
public class CarAdController {
    private final CarAdService carAdService;

    @GetMapping
    public List<CarAdDto> getAll(){
        return carAdService.getAll();
    }

}

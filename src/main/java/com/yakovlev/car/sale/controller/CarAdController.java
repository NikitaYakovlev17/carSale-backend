package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.carAd.CarAdDto;
import com.yakovlev.car.sale.dto.model.ModelDto;
import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.model.CarAd;
import com.yakovlev.car.sale.model.CarAdPage;
import com.yakovlev.car.sale.model.CarAdSearchCriteria;
import com.yakovlev.car.sale.service.CarAdService;
import com.yakovlev.car.sale.service.ModelService;
import com.yakovlev.car.sale.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/car-ad")
public class CarAdController {
    private final CarAdService carAdService;
    private final ProducerService producerService;
    private final ModelService modelService;

    @GetMapping("/producers")
    public List<ProducerDto> getAllProducers(){
        return producerService.getAll();
    }

    @GetMapping
    public List<CarAdDto> getAll(){
        return carAdService.getAll();
    }

    @GetMapping("/{id}")
    public CarAdDto getById(@PathVariable Long id){
        return carAdService.getById(id);
    }

    @GetMapping("/models/{id}")
    public List<ModelDto> getAllModelsByProducerId(@PathVariable Long id){
        return modelService.getAllByProducerId(id);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarAdDto>> getCarAds(CarAdPage carAdPage, CarAdSearchCriteria carAdSearchCriteria){
        return new ResponseEntity<>(carAdService.getCarAds(carAdPage, carAdSearchCriteria),
                HttpStatus.OK);
    }

}

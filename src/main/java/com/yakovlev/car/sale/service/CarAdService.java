package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.carAd.CarAdDto;
import com.yakovlev.car.sale.mapper.CarAdMapper;
import com.yakovlev.car.sale.model.CarAd;
import com.yakovlev.car.sale.model.CarAdPage;
import com.yakovlev.car.sale.model.CarAdSearchCriteria;
import com.yakovlev.car.sale.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarAdService {
    private final CarAdRepository carAdRepository;
    private final GenerationRepository generationRepository;
    private final BodyRepository bodyRepository;
    private final TransmissionRepository transmissionRepository;
    private final EngineRepository engineRepository;
    private final DriveRepository driveRepository;
    private final ColorRepository colorRepository;
    private final UserRepository userRepository;
    private final CarAdCriteriaRepository carAdCriteriaRepository;
    private final CarAdMapper carAdMapper;

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

    public CarAd add(CarAdDto carAdDto){
        CarAd carAd = this.carAdRepository.save(
                CarAd.builder()
                        .price(carAdDto.getPrice())
                        .mileage(carAdDto.getMileage())
                        .description(carAdDto.getDescription())
                        .year(carAdDto.getYear())
                        .location(carAdDto.getLocation())
                        .generation(this.generationRepository.getById(carAdDto.getGeneration().getId()))
                        .body(this.bodyRepository.getBodyByName(carAdDto.getBody().getName()))
                        .transmission(this.transmissionRepository.getTransmissionByType(carAdDto.getTransmission().getType()))
                        .engine(this.engineRepository.getById(carAdDto.getEngine().getId()))
                        .drive(this.driveRepository.getDriveByType(carAdDto.getDrive().getType()))
                        .color(this.colorRepository.getColorByName(carAdDto.getColor().getName()))
                        .user(this.userRepository.getById(carAdDto.getUser().getId()))
                        .build()
        );
        return carAd;
    }
}

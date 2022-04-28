package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.carPhoto.CarPhotoDto;
import com.yakovlev.car.sale.dto.model.ModelDto;
import com.yakovlev.car.sale.mapper.CarPhotoMapper;
import com.yakovlev.car.sale.mapper.ModelMapper;
import com.yakovlev.car.sale.model.CarPhoto;
import com.yakovlev.car.sale.repository.ModelRepository;
import com.yakovlev.car.sale.repository.СarPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarPhotoService {
    private final СarPhotoRepository carPhotoRepository;
    private final CarPhotoMapper carPhotoMapper;

    public void savePhoto(CarPhoto carPhoto){
        carPhotoRepository.save(carPhoto);
    }

    public CarPhoto getPhoto(Long id){
        return carPhotoRepository.getById(id);
    }

    public List<CarPhotoDto> getAllByCarAdId(Long id){
        return carPhotoMapper.toDto(carPhotoRepository.getAllByCarAdId(id));
    }
}

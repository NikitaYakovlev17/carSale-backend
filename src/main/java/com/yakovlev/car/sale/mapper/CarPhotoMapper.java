package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.carPhoto.CarPhotoDto;
import com.yakovlev.car.sale.dto.generation.GenerationDto;
import com.yakovlev.car.sale.model.CarPhoto;
import com.yakovlev.car.sale.model.Generation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarPhotoMapper {
    CarPhotoDto toDto(CarPhoto source);

    List<CarPhotoDto> toDto(List<CarPhoto> source);
}

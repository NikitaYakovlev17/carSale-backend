package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.carAd.CarAdDto;
import com.yakovlev.car.sale.model.CarAd;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CarAdMapper {
    CarAdDto toDto(CarAd source);
    List<CarAdDto> toDto(List<CarAd> source);
    Collection<CarAdDto> toDto(Collection<CarAd> source);
}

package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.transmission.TransmissionDto;
import com.yakovlev.car.sale.model.Transmission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransmissionMapper {
    TransmissionDto toDto(Transmission source);

    List<TransmissionDto> toDto(List<Transmission> source);
}

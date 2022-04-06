package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.generation.GenerationDto;
import com.yakovlev.car.sale.model.Generation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenerationMapper {
    GenerationDto toDto(Generation source);

    List<GenerationDto> toDto(List<Generation> source);
}

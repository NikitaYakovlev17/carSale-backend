package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.engine.EngineDto;
import com.yakovlev.car.sale.model.Engine;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EngineMapper {
    EngineDto toDto(Engine source);

    List<EngineDto> toDto(List<Engine> source);
}

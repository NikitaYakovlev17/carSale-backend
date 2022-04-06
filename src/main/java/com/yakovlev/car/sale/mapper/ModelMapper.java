package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.model.ModelDto;
import com.yakovlev.car.sale.model.Model;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    ModelDto toDto(Model source);

    List<ModelDto> toDto(List<Model> source);
}

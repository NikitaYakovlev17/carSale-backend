package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.color.ColorDto;
import com.yakovlev.car.sale.model.Color;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    ColorDto toDto(Color source);

    List<ColorDto> toDto(List<Color> source);
}

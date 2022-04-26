package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.body.BodyDto;
import com.yakovlev.car.sale.model.Body;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationName = "test")
public interface BodyMapper {
    BodyDto toDto(Body source);

    List<BodyDto> toDto(List<Body> source);
}

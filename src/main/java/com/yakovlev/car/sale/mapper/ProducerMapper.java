package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.model.Producer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProducerMapper {
    ProducerDto toDto(Producer source);

    List<ProducerDto> toDto(List<Producer> source);
}

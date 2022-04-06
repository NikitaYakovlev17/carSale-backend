package com.yakovlev.car.sale.dto.model;

import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.model.Producer;
import lombok.Data;

@Data
public class ModelDto {
    Long id;
    String name;
    ProducerDto producer;
}

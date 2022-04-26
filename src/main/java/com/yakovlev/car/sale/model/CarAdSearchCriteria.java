package com.yakovlev.car.sale.model;

import com.yakovlev.car.sale.dto.body.BodyDto;
import com.yakovlev.car.sale.dto.generation.GenerationDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class CarAdSearchCriteria {
    private String mileage;
    private String description;
    private Generation generation;
    private Body body;
}

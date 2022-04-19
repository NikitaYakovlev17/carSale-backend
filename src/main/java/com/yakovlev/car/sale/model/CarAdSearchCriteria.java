package com.yakovlev.car.sale.model;

import com.yakovlev.car.sale.dto.generation.GenerationDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarAdSearchCriteria {
    private String mileage;
    private String description;
    private Generation generation;
    private Body body;
}

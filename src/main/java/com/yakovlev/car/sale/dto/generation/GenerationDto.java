package com.yakovlev.car.sale.dto.generation;

import com.yakovlev.car.sale.dto.model.ModelDto;
import com.yakovlev.car.sale.model.Model;
import lombok.Data;

@Data
public class GenerationDto {
    Long id;
    String name;
    Integer startOfProduction;
    Integer endOfProduction;
    ModelDto model;
}

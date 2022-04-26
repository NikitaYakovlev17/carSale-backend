package com.yakovlev.car.sale.dto.carAd;

import com.yakovlev.car.sale.dto.generation.GenerationDto;
import com.yakovlev.car.sale.model.*;
import com.yakovlev.car.sale.model.enums.ActivityStatus;
import lombok.Data;

@Data
public class CarAdDto {
    Long id;
    Integer price;
    String mileage;
    String description;
    Integer year;
    GenerationDto generation;
    Body body;
    Transmission transmission;
    Engine engine;
    Drive drive;
    Color color;
}

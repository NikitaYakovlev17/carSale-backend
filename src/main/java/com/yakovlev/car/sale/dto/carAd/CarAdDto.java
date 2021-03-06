package com.yakovlev.car.sale.dto.carAd;

import com.yakovlev.car.sale.dto.generation.GenerationDto;
import com.yakovlev.car.sale.dto.user.UserDto;
import com.yakovlev.car.sale.model.*;
import com.yakovlev.car.sale.model.enums.ActivityStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data
public class CarAdDto {
    Long id;
    LocalDate createdOn;
    Integer price;
    String mileage;
    String description;
    Integer year;
    String location;
    GenerationDto generation;
    Body body;
    Transmission transmission;
    Engine engine;
    Drive drive;
    Color color;
    UserDto user;
}

package com.yakovlev.car.sale.dto.admin;

import lombok.Data;

@Data
public class AdminDto {
    String fieldName;
    String name;
    String type;
    Integer displacement;
    Long foreignId;
    Integer startOfProduction;
    Integer endOfProduction;
}

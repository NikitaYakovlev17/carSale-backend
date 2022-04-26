package com.yakovlev.car.sale.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class CarPhoto extends BaseEntity {
    @Column
    private String path;
}

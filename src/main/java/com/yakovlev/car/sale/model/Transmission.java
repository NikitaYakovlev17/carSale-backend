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
public class Transmission extends BaseEntity {
    @Column(nullable = false)
    private String type;
}

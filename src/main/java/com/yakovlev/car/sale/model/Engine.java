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
public class Engine extends BaseEntity {
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer displacement;
}

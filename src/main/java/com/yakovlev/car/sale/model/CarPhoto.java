package com.yakovlev.car.sale.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name = "car_ad_id", nullable = false)
    private CarAd carAd;
}

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
public class Kitting extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "car_ad_id", nullable = false)
    private CarAd carAd;
}

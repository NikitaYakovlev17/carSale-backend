package com.yakovlev.car.sale.model;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "car_ad_id", nullable = false)
    private CarAd carAd;
}

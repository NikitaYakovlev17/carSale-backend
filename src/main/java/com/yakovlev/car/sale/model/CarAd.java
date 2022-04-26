package com.yakovlev.car.sale.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class CarAd extends BaseEntity {

    @Column
    private Integer price;

    @Column(nullable = false)
    private String mileage;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Generation generation;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Body body;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Transmission transmission;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Engine engine;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Drive drive;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Color color;

    @OneToMany(mappedBy = "carAd", fetch = FetchType.LAZY)
    private Collection<Kitting> kittings;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

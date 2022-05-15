package com.yakovlev.car.sale.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class CarAd extends BaseEntityWithCreatedDate {

    @Column
    private Integer price;

    @Column(nullable = false)
    private String mileage;

    @Column(length = 5000)
    private String description;

    @Column
    private Integer year;

    @Column
    private String location;

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

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "carAd", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Collection<CarPhoto> carPhotos;

    @ManyToMany(mappedBy = "likedCarAds")
    private Collection<User> likes;
}

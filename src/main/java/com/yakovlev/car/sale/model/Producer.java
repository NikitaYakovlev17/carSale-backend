package com.yakovlev.car.sale.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Producer extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "producer", fetch = FetchType.LAZY)
    private Collection<Model> models;
}

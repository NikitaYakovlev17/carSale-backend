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
public class Model extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "producer_id", nullable = false)
    private Producer producer;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private Collection<Generation> generations;
}

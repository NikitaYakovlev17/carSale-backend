package com.yakovlev.car.sale.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Generation extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer startOfProduction;

    @Column(nullable = false)
    private Integer endOfProduction;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;
}

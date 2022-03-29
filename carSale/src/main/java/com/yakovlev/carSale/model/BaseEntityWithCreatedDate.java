package com.yakovlev.carSale.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public class BaseEntityWithCreatedDate {
    @Id
    @GeneratedValue
    public Long id;

    @CreatedDate
    private LocalDate createdOn;
}
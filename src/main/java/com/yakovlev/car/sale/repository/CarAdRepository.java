package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.CarAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarAdRepository extends JpaRepository<CarAd, Long> {
    List<CarAd> findAll();

    CarAd getById(Long id);
}

package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.CarAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarAdRepository extends JpaRepository<CarAd, Long> {
}

package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.Color;
import com.yakovlev.car.sale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
}

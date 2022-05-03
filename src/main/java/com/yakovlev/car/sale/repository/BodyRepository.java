package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.Body;
import com.yakovlev.car.sale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodyRepository extends JpaRepository<Body, Long> {
    Body getBodyByName(String name);
}

package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.Transmission;
import com.yakovlev.car.sale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Long> {
}

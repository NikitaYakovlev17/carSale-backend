package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.Producer;
import com.yakovlev.car.sale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}

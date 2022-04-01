package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.Generation;
import com.yakovlev.car.sale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Long> {
}

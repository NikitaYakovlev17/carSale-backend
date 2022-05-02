package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.Generation;
import com.yakovlev.car.sale.model.Model;
import com.yakovlev.car.sale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Long> {
    List<Generation> getAllByModelName(String name);
    //List<Integer> getYearsByGenerationId(Long id);

    Generation getGenerationById(Long id);
}

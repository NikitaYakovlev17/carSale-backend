package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.CarAd;
import com.yakovlev.car.sale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarAdRepository extends JpaRepository<CarAd, Long> {
    List<CarAd> findAll();

    CarAd getById(Long id);

    List<CarAd> findByLikes(User user);

    List<CarAd> findAllByUserId(Long id);

    void deleteById(Long id);
}

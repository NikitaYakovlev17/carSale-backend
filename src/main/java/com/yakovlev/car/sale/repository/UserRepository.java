package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.dto.carAd.CarAdDto;
import com.yakovlev.car.sale.model.CarAd;
import com.yakovlev.car.sale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User getById(Long id);

    List<User> findUsersByLikedCarAds(CarAd carAd);
}

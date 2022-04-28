package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.CarPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface СarPhotoRepository extends JpaRepository<CarPhoto, Long> {
    CarPhoto save(CarPhoto carPhoto);
    CarPhoto getById(Long id);

    List<CarPhoto> getAllByCarAdId(Long id);
}

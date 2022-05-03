package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.model.Drive;
import com.yakovlev.car.sale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriveRepository extends JpaRepository<Drive, Long> {
    Drive getDriveByType(String type);
}

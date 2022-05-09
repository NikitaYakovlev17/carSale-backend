package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.admin.AdminDto;
import com.yakovlev.car.sale.dto.drive.DriveDto;
import com.yakovlev.car.sale.mapper.DriveMapper;
import com.yakovlev.car.sale.model.Drive;
import com.yakovlev.car.sale.model.Producer;
import com.yakovlev.car.sale.repository.DriveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriveService {
    private final DriveRepository driveRepository;
    private final DriveMapper driveMapper;

    public List<DriveDto> getAllDrives() {
        return driveMapper.toDto(driveRepository.findAll());
    }

    public void add(AdminDto adminDto){
        this.driveRepository.save(
                Drive.builder()
                        .type(adminDto.getType())
                        .build()
        );
    }
}

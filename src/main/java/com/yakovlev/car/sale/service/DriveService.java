package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.drive.DriveDto;
import com.yakovlev.car.sale.mapper.DriveMapper;
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

}

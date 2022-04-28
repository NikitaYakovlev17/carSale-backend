package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.drive.DriveDto;
import com.yakovlev.car.sale.service.DriveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/drive")
public class DriveController {

    private final DriveService driveService;

    @GetMapping("/all")
    public List<DriveDto> getAllDrives(){
        return driveService.getAllDrives();
    }
}

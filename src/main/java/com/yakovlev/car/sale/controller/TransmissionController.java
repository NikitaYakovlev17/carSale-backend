package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.body.BodyDto;
import com.yakovlev.car.sale.dto.transmission.TransmissionDto;
import com.yakovlev.car.sale.service.BodyService;
import com.yakovlev.car.sale.service.TransmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/transmission")
public class TransmissionController {

    private final TransmissionService transmissionService;

    @GetMapping("/all")
    public List<TransmissionDto> getAllTransmissions(){
        return transmissionService.getAllTransmissions();
    }
}

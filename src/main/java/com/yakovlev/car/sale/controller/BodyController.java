package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.body.BodyDto;
import com.yakovlev.car.sale.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/body")
public class BodyController {

    private final BodyService bodyService;

    @GetMapping("/all")
    public List<BodyDto> getAllBodies(){
        return bodyService.getAllBodies();
    }
}

package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.engine.EngineDto;
import com.yakovlev.car.sale.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/engine")
public class EngineController {

    private final EngineService engineService;

    @GetMapping("/all")
    public List<EngineDto> getAllEngines(){
        return engineService.getAllEngines();
    }
}

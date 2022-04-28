package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.generation.GenerationDto;
import com.yakovlev.car.sale.service.GenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/model")
public class ModelController {
    private final GenerationService generationService;

    @GetMapping("/{model}")
    public List<GenerationDto> getAllGenerationsByModelName(@PathVariable String model){
        return generationService.getAllByModelName(model);
    }
}

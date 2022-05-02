package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.service.GenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/generation")
public class GenerationController {
    private final GenerationService generationService;

    @GetMapping("/years/{id}")
    public List<Integer> getYearsByGenerationId(@PathVariable Long id){
        return generationService.getYearsByGenerationId(id);
    }
}

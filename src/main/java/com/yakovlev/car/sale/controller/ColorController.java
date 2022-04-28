package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.color.ColorDto;
import com.yakovlev.car.sale.dto.generation.GenerationDto;
import com.yakovlev.car.sale.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/color")
public class ColorController {
    private final ColorService colorService;


    @GetMapping("/all")
    public List<ColorDto> getAllColors(){
        return colorService.getAllColors();
    }

}

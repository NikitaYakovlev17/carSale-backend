package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.admin.AdminDto;
import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.mapper.ProducerMapper;
import com.yakovlev.car.sale.model.Producer;
import com.yakovlev.car.sale.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/admin")
public class AdminController {
    private final ProducerService producerService;
    private final ColorService colorService;
    private final BodyService bodyService;
    private final EngineService engineService;
    private final ModelService modelService;
    private final GenerationService generationService;

    @GetMapping("/add")
    public List<ProducerDto> getAdd(@RequestBody AdminDto adminDto){
        List<ProducerDto> producerDto = null;
        switch (adminDto.getFieldName()){
            case "model":
                producerDto = producerService.getAll();
                break;
            case "generation":
                producerDto = producerService.getAll();
                break;
        }
        return producerDto;
    }

    @PostMapping("/add")
    public void add(@RequestBody AdminDto adminDto){
        switch (adminDto.getFieldName()){
            case "color" :
                colorService.add(adminDto);
                break;
            case "producer":
                producerService.add(adminDto);
                break;
            case "model":
                modelService.add(adminDto);
                break;
            case "generation":
                generationService.add(adminDto);
                break;
            case "body":
                bodyService.add(adminDto);
                break;
            case "engine":
                engineService.add(adminDto);
                break;
        }
    }
}

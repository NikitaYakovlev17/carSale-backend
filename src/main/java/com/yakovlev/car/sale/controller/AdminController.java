package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.admin.AdminDto;
import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.mapper.ProducerMapper;
import com.yakovlev.car.sale.model.Producer;
import com.yakovlev.car.sale.model.enums.AdminFieldName;
import com.yakovlev.car.sale.model.enums.EngineType;
import com.yakovlev.car.sale.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping
    public ResponseEntity<List<AdminFieldName>> fields(){
        return new ResponseEntity<List<AdminFieldName>>(Arrays.asList(AdminFieldName.values()), HttpStatus.OK);
    }

    @GetMapping("/engine")
    public ResponseEntity<List<EngineType>> engineType(){
        return new ResponseEntity<List<EngineType>>(Arrays.asList(EngineType.values()), HttpStatus.OK);
    }

    @GetMapping("/add")
    public List<ProducerDto> getAdd(@RequestBody AdminDto adminDto){
        List<ProducerDto> producerDto = null;
        switch (adminDto.getFieldName()){
            case "Model":
                producerDto = producerService.getAll();
                break;
            case "Generation":
                producerDto = producerService.getAll();
                break;
        }
        return producerDto;
    }

    @PostMapping("/add")
    public void add(@RequestBody AdminDto adminDto){
        switch (adminDto.getFieldName()){
            case "Color" :
                colorService.add(adminDto);
                break;
            case "Producer":
                producerService.add(adminDto);
                break;
            case "Model":
                modelService.add(adminDto);
                break;
            case "Generation":
                generationService.add(adminDto);
                break;
            case "Body":
                bodyService.add(adminDto);
                break;
            case "Engine":
                engineService.add(adminDto);
                break;
        }
    }
}

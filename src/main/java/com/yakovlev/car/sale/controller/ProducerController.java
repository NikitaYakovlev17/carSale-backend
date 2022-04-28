package com.yakovlev.car.sale.controller;

import com.yakovlev.car.sale.dto.model.ModelDto;
import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.service.GenerationService;
import com.yakovlev.car.sale.service.ModelService;
import com.yakovlev.car.sale.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/producer")
public class ProducerController {

    private final ProducerService producerService;
    private final ModelService modelService;

    @GetMapping("/all")
    public List<ProducerDto> getAllProducers() {
        return producerService.getAll();
    }

    @GetMapping("/{producer}")
    public List<ModelDto> getAllModelsByProducerName(@PathVariable String producer) {
        return modelService.getAllByProducerName(producer);
    }
}

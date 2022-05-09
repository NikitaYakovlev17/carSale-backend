package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.admin.AdminDto;
import com.yakovlev.car.sale.dto.model.ModelDto;
import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.mapper.ModelMapper;
import com.yakovlev.car.sale.mapper.ProducerMapper;
import com.yakovlev.car.sale.model.Model;
import com.yakovlev.car.sale.model.Producer;
import com.yakovlev.car.sale.repository.ModelRepository;
import com.yakovlev.car.sale.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;
    private final ProducerRepository producerRepository;
    private final ModelMapper modelMapper;

    public List<ModelDto> getAllByProducerName(String name) {
        return modelMapper.toDto(modelRepository.getAllByProducerName(name));
    }

    public void add(AdminDto adminDto){
        Producer producer = producerRepository.getById(adminDto.getForeignId());
        this.modelRepository.save(
                Model.builder()
                        .name(adminDto.getName())
                        .producer(producer)
                        .build()
        );
    }
}

package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.mapper.ProducerMapper;
import com.yakovlev.car.sale.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;

    public List<ProducerDto> getAll() {
        return producerMapper.toDto(producerRepository.findAll());
    }

}

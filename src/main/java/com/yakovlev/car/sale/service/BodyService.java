package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.body.BodyDto;
import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.mapper.BodyMapper;
import com.yakovlev.car.sale.mapper.ProducerMapper;
import com.yakovlev.car.sale.repository.BodyRepository;
import com.yakovlev.car.sale.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodyService {
    private final BodyRepository bodyRepository;
    private final BodyMapper bodyMapper;

    public List<BodyDto> getAllBodies() {
        return bodyMapper.toDto(bodyRepository.findAll());
    }

}

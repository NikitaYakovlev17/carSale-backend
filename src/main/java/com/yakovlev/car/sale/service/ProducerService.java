package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.RegistrationRequestDto;
import com.yakovlev.car.sale.dto.admin.AdminDto;
import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.mapper.ProducerMapper;
import com.yakovlev.car.sale.model.Producer;
import com.yakovlev.car.sale.model.User;
import com.yakovlev.car.sale.model.enums.ActivityStatus;
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

    public void add(AdminDto adminDto){
        this.producerRepository.save(
                Producer.builder()
                        .name(adminDto.getName())
                        .build()
        );
    }
}

package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.transmission.TransmissionDto;
import com.yakovlev.car.sale.mapper.TransmissionMapper;
import com.yakovlev.car.sale.repository.TransmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransmissionService {
    private final TransmissionRepository transmissionRepository;
    private final TransmissionMapper transmissionMapper;

    public List<TransmissionDto> getAllTransmissions() {
        return transmissionMapper.toDto(transmissionRepository.findAll());
    }

}

package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.engine.EngineDto;
import com.yakovlev.car.sale.mapper.EngineMapper;
import com.yakovlev.car.sale.repository.EngineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineService {
    private final EngineRepository engineRepository;
    private final EngineMapper engineMapper;

    public List<EngineDto> getAllEngines() {
        return engineMapper.toDto(engineRepository.findAll());
    }

}

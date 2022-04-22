package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.generation.GenerationDto;
import com.yakovlev.car.sale.dto.model.ModelDto;
import com.yakovlev.car.sale.mapper.GenerationMapper;
import com.yakovlev.car.sale.mapper.ModelMapper;
import com.yakovlev.car.sale.model.Model;
import com.yakovlev.car.sale.repository.GenerationRepository;
import com.yakovlev.car.sale.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenerationService {
    private final GenerationRepository generationRepository;
    private final GenerationMapper generationMapper;

    public List<GenerationDto> getAllByModelName(String name) {
        return generationMapper.toDto(generationRepository.getAllByModelName(name));
    }

}

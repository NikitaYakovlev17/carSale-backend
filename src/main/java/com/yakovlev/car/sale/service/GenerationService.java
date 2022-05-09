package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.admin.AdminDto;
import com.yakovlev.car.sale.dto.generation.GenerationDto;
import com.yakovlev.car.sale.dto.model.ModelDto;
import com.yakovlev.car.sale.mapper.GenerationMapper;
import com.yakovlev.car.sale.mapper.ModelMapper;
import com.yakovlev.car.sale.model.Generation;
import com.yakovlev.car.sale.model.Model;
import com.yakovlev.car.sale.model.Producer;
import com.yakovlev.car.sale.repository.GenerationRepository;
import com.yakovlev.car.sale.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenerationService {
    private final GenerationRepository generationRepository;
    private final ModelRepository modelRepository;
    private final GenerationMapper generationMapper;

    public List<GenerationDto> getAllByModelName(String name) {
        return generationMapper.toDto(generationRepository.getAllByModelName(name));
    }

    public List<Integer> getYearsByGenerationName(String name){
        Generation generation = generationRepository.getGenerationByName(name);
        List<Integer> years = new ArrayList<>();
        for (int i = generation.getStartOfProduction(); i <= generation.getEndOfProduction(); i++) {
            years.add(i);
        }
        return years;
    }

    public void add(AdminDto adminDto){
        Model model = modelRepository.getById(adminDto.getForeignId());
        this.generationRepository.save(
                Generation.builder()
                        .name(adminDto.getName())
                        .startOfProduction(adminDto.getStartOfProduction())
                        .endOfProduction(adminDto.getEndOfProduction())
                        .model(model)
                        .build()
        );
    }

}

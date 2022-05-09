package com.yakovlev.car.sale.service;

import com.yakovlev.car.sale.dto.admin.AdminDto;
import com.yakovlev.car.sale.dto.color.ColorDto;
import com.yakovlev.car.sale.mapper.ColorMapper;
import com.yakovlev.car.sale.model.Color;
import com.yakovlev.car.sale.model.Producer;
import com.yakovlev.car.sale.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository colorRepository;
    private final ColorMapper colorMapper;

    public List<ColorDto> getAllColors() {
        return colorMapper.toDto(colorRepository.findAll());
    }

    public void add(AdminDto adminDto){
        this.colorRepository.save(
                Color.builder()
                        .name(adminDto.getName())
                        .build()
        );
    }

}

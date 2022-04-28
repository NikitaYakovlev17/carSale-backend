package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.drive.DriveDto;
import com.yakovlev.car.sale.model.Drive;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriveMapper {
    DriveDto toDto(Drive source);

    List<DriveDto> toDto(List<Drive> source);
}

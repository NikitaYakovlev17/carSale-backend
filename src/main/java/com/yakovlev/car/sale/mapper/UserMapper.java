package com.yakovlev.car.sale.mapper;

import com.yakovlev.car.sale.dto.user.UserDto;
import com.yakovlev.car.sale.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User source);

    List<UserDto> toDto(List<User> source);
}

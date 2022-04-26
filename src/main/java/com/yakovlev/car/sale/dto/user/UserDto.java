package com.yakovlev.car.sale.dto.user;

import com.yakovlev.car.sale.model.Role;
import com.yakovlev.car.sale.model.enums.ActivityStatus;
import lombok.Data;

@Data
public class UserDto {
    Long id;
    String email;
    String firstName;
    String phoneNumber;
    Role role;
    ActivityStatus status;
}

package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

  public EmployeeDto toDto(EmployeeEntity entity) {
    EmployeeDto dto = new EmployeeDto();
    dto.setId(entity.getId());
//    dto.setCode(entity.getCode());
    dto.setFullname(entity.getFullname());
    dto.setEmail(entity.getEmail());
    dto.setAddress(entity.getAddress());
    dto.setPhone(entity.getPhone());
    return dto;
  }

  public EmployeeEntity toEntity(EmployeeDto dto) {
    EmployeeEntity entity = new EmployeeEntity();
    entity.setId(dto.getId());
//    entity.setCode(dto.getCode());
    entity.setEmail(dto.getEmail());
    entity.setAddress(dto.getAddress());
    entity.setPhone(dto.getPhone());
    return entity;
  }
}

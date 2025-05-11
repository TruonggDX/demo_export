package com.example.demo.dto;

import lombok.Data;

@Data
public class EmployeeDto {

  private Long id;
  private String fullname;
  private String email;
  private String phone;
  private String address;
}

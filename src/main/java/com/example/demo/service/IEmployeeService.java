package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import java.util.List;

public interface IEmployeeService {

  List<EmployeeDto> getAllEmployees();
}

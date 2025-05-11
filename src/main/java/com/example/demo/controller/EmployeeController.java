package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.IEmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
  public final IEmployeeService employeeService;
  @GetMapping("/list")
  public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
    return ResponseEntity.ok(employeeService.getAllEmployees());
  }
}

package com.example.demo.repository;

import com.example.demo.entity.EmployeeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

  @Query(value = "SELECT e FROM EmployeeEntity e WHERE e.deleted=false")
  List<EmployeeEntity> findAllByDeletedFalse();

  @Query(value = "SELECT e FROM EmployeeEntity e WHERE e.deleted=false AND e.email=:email")
  EmployeeEntity findByEmail(@Param("email") String email);
}

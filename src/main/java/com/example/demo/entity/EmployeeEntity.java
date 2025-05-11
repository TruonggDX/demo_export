package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String fullname;
  private String email;
  private String phone;
  private String address;
  private String password;
  @Column(name = "created_date")
  private LocalDateTime createdDate;
  @Column(name = "created_by")
  private String createdBy;
  @Column(name = "modified_date")
  private LocalDateTime modifiedDate;
  @Column(name = "modified_by")
  private String modifiedBy;
  @Column(name = "deleted", columnDefinition = "tinyint(1) default 0")
  private Boolean deleted;
}

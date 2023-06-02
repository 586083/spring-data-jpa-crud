package com.arc.spring.jpa.CRUD.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
public class Employee implements Serializable {

    @Id
    private Long employeeId;

    @Column
    private String employeeName;

    @Column
    private BigDecimal employeeSalary;
}

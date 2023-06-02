package com.arc.spring.jpa.CRUD.dao;

import com.arc.spring.jpa.CRUD.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT new com.arc.spring.jpa.CRUD.dto.Employee(employeeId,employeeName,employeeSalary) FROM Employee WHERE employeeSalary >= ?1")
    List<Employee> findEmployeeBySalary(BigDecimal salary);
}

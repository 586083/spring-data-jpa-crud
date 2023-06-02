package com.arc.spring.jpa.CRUD.service;

import com.arc.spring.jpa.CRUD.dto.Employee;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;


public interface EmployeeService {
    Employee findEmployeeById(@RequestParam Long employeeId);

    List<Employee> getAllEmployee();

    List<Employee> findEmployeeBySalary(BigDecimal salary);

    boolean createEmployee(Employee employee);

    boolean updateemployee(Employee employee);

    void deleteemployee(Employee employee);
}

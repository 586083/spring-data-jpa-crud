package com.arc.spring.jpa.CRUD.service.impl;

import com.arc.spring.jpa.CRUD.dao.EmployeeRepository;
import com.arc.spring.jpa.CRUD.dto.Employee;
import com.arc.spring.jpa.CRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findEmployeeBySalary(BigDecimal salary) {
        return employeeRepository.findEmployeeBySalary(salary);
    }

    @Override
    public boolean createEmployee(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return ObjectUtils.isEmpty(emp) ? false : true;
    }

    @Override
    public boolean updateemployee(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return ObjectUtils.isEmpty(emp) ? false : true;
    }

    @Override
    public void deleteemployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}

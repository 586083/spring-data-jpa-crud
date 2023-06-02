package com.arc.spring.jpa.CRUD.controller;

import com.arc.spring.jpa.CRUD.dto.Employee;
import com.arc.spring.jpa.CRUD.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/empolyee")
@Slf4j
@Api(value = "Employee Management", protocols = "http")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ApiOperation(value= "Fetch All Employee Details", response = Employee.class)
    public @ResponseBody List<Employee> getAllEmployee() {
        List employeList = employeeService.getAllEmployee();
        log.info("getAllEmployee={}", employeList.size());
        return employeList;
    }

    @GetMapping("/getemployeebyid")
    @ApiOperation(value= "Fetch a Employee Detail by ID", response = Employee.class)
    public @ResponseBody Employee findEmployeeById(@ApiParam("Employee Id") @RequestParam(name="id") Long employeeId) {
        log.info("findEmployeeById={}", employeeId);
        return employeeService.findEmployeeById(employeeId);
    }

    @GetMapping("/getemployeebysalary")
    @ApiOperation(value= "Fetch a Employee based on salary", response = Employee.class)
    public @ResponseBody List<Employee> findEmployeeBySalary(@ApiParam("Salary") @RequestParam(name="salary") BigDecimal salary) {
        log.info("findEmployeeBySalary={}", salary);
        return employeeService.findEmployeeBySalary(salary);
    }

    @PostMapping
    @ApiOperation(value = "insert an employee")
    public @ResponseBody boolean createEmployee(@RequestBody Employee employee) {
        log.info("createEmployee={}", employee.toString());
        return employeeService.createEmployee(employee);
    }

    @PutMapping
    @ApiOperation(value = "update an employee")
    public @ResponseBody boolean updateemployee(@RequestBody Employee employee) {
        log.info("updateemployee={}", employee.toString());
        return employeeService.updateemployee(employee);
    }

    @DeleteMapping
    @ApiOperation(value = "delete an employee")
    public @ResponseBody void deleteemployee(@RequestBody Employee employee) {
        log.info("deleteemployee={}", employee.toString());
        employeeService.deleteemployee(employee);
    }
}

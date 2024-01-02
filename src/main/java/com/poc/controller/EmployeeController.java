package com.poc.controller;

import com.poc.exception.RandomException;
import com.poc.model.Employee;
import com.poc.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        log.info("Fetching Employee with Id: {}", id);
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/emp/all")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees...");
        return employeeService.getAllEmployees();
    }

    @PostMapping("/emp/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("Adding employee: {}", employee);
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/emp/error")
    public Object throwException() {
        log.info("Throwing a Random exception...");
        throw new RandomException("Some Random Exception");
    }
}

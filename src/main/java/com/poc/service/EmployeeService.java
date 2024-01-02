package com.poc.service;

import com.poc.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<Long, Employee> employeeData = new HashMap<>();
    private static Long employeeId = 0L;

    public Employee getEmployeeById(long id) {
        return employeeData.get(id);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeData.values());
    }

    public Employee addEmployee(Employee employee) {
        long empId = randomEmployeeIdGenerator();
        employee.setId(empId);

        employeeData.put(empId, employee);

        return employee;
    }

    private static long randomEmployeeIdGenerator() {
        employeeId = employeeId + 1;
        return employeeId;
    }
}

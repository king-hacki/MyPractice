package com.example.rest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path = "/employees")
    List<Employee> all() {
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/employees")
    Employee newEmployee (@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping(path = "/employees/{id}")
    Employee one (@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundExeptionError(id));
    }

    @PutMapping(path = "/employees/{id}")
    Employee replaceEmployee (@RequestBody Employee newEmployee, @PathVariable Long id) {
        return  employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return  employeeRepository.save(employee);
                }).orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee (@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}

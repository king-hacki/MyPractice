package com.example.rest.demo;

public class EmployeeNotFoundExeptionError extends RuntimeException {
    EmployeeNotFoundExeptionError (Long id) {
        super ("Could not find employee " + id);
    }
}

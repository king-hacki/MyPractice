package com.example.rest.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundExeptionError.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler (EmployeeNotFoundExeptionError ex) {
        return ex.getMessage();
    }
}

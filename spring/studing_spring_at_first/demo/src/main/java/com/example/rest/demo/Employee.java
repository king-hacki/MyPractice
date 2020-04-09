package com.example.rest.demo;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Data
@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    public Employee () {}

    Employee (String name, String role) {
        this.name = name;
        this.role = role;
    }

}

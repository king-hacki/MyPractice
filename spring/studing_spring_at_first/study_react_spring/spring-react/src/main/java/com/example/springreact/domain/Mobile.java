package com.example.springreact.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Model can't be blank")
    private String model;
    @NotBlank(message = "Year can't be blank")
    private String year;
    @NotBlank(message = "Name can't be blank")
    private String name;
    private String status;
}

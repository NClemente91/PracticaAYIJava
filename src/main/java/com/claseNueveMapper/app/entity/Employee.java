package com.claseNueveMapper.app.entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Employee {

    private Integer idEmployee;
    private Date startContract;
    private Double salary;
    private Integer idPersonEmployee;

    public Employee(Date startContract, Double salary, Integer idPersonEmployee) {
        this.startContract = startContract;
        this.salary = salary;
        this.idPersonEmployee = idPersonEmployee;
    }
}

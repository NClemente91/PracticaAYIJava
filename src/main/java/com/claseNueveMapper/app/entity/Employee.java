package com.claseNueveMapper.app.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class Employee extends Person {

    private Double salary;

}

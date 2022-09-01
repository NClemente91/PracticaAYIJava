package com.claseNueveMapper.app.dtos.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeResponseDTO {

    private Integer idEmployee;
    private String name;
    private String lastName;
    private Integer age;
    private String address;
    private Double salary;
}
package com.claseNueveMapper.app.dtos.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class PersonDTO {

    private String name;
    private String lastName;
    private Integer age;
    private String address;
    /*Podríamos tener algo así también, va a depender en el contexto, de la complejidad
    prívate Link<CustomerDTO> customerDTO */
}

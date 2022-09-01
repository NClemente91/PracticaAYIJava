package com.claseNueveMapper.app.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Person {
    private Integer idPerson;
    private String name;
    private String lastName;
    private Integer age;
    private String address;

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Person(String name, String lastName, Integer age, String address) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }
}

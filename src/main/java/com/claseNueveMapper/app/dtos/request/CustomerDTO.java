package com.claseNueveMapper.app.dtos.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CustomerDTO{

    private String name;
    private String lastName;
    private Integer age;
    private String address;
    private String vip;

}

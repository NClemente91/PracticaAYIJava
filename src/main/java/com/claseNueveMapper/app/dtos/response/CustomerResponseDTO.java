package com.claseNueveMapper.app.dtos.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CustomerResponseDTO {

    private Integer idCustomer;
    private String name;
    private String lastName;
    private Integer age;
    private String address;
    private Double salary;
    private String vip;

}

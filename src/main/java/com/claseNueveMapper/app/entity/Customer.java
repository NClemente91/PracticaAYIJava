package com.claseNueveMapper.app.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class Customer extends Person {

    private Integer idCustomer;
    private boolean vip;

}

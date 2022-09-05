package com.claseNueveMapper.app.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Customer {

    private Integer idCustomer;
    private boolean vip;
    private Integer idPersonCustomer;

    public Customer(boolean vip, Integer idPersonCustomer) {
        this.vip = vip;
        this.idPersonCustomer = idPersonCustomer;
    }
}

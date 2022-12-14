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
    private Double accountBalance;
    private Integer idPersonCustomer;

    public Customer(boolean vip, Double accountBalance, Integer idPersonCustomer) {
        this.vip = vip;
        this.accountBalance = accountBalance;
        this.idPersonCustomer = idPersonCustomer;
    }
}

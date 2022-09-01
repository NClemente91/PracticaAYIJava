package com.claseNueveMapper.app.service;

import com.claseNueveMapper.app.dtos.request.CustomerDTO;
import com.claseNueveMapper.app.dtos.response.CustomerResponseDTO;
import com.claseNueveMapper.app.entity.Customer;

import java.util.List;

public interface ICustomerService {

    void insertCustomer(Customer customer);

    CustomerResponseDTO updateCustomer(CustomerDTO customer, Integer id);

    void deleteCustomer(Integer id);

    List<Customer> getAllCustomers();

}

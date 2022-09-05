package com.claseNueveMapper.app.service;

import com.claseNueveMapper.app.dtos.request.CustomerDTO;
import com.claseNueveMapper.app.dtos.response.CustomerResponseDTO;
import com.claseNueveMapper.app.entity.Customer;
import com.claseNueveMapper.app.entity.Employee;

import java.util.List;

public interface ICustomerService {

    void insertCustomer(Customer customer);

    CustomerResponseDTO updateCustomer(CustomerDTO customer, Integer id);

    void deleteCustomer(Integer id);

    List<Customer> getAllCustomers();

    Customer getOneCustomer(Integer id);

}

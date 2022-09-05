package com.claseNueveMapper.app.controller;

import com.claseNueveMapper.app.dtos.request.CustomerDTO;
import com.claseNueveMapper.app.dtos.response.CustomerResponseDTO;
import com.claseNueveMapper.app.entity.Customer;
import com.claseNueveMapper.app.entity.Employee;
import com.claseNueveMapper.app.service.ICustomerService;
import com.claseNueveMapper.app.service.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {

    ICustomerService iCustomerService = new CustomerServiceImpl();

    public void addCustomer(Customer customer) {
        iCustomerService.insertCustomer(customer);
    }

    public void deleteCustomer(Integer id) {
        iCustomerService.deleteCustomer(id);
    }

    public List<Customer> listAllCustomers() {
        return iCustomerService.getAllCustomers();
    }

    public CustomerResponseDTO updateCustomer(CustomerDTO customerDTO, Integer id) {
        return iCustomerService.updateCustomer(customerDTO, id);
    }

    public Customer listOneCustomer(Integer id) {
        return iCustomerService.getOneCustomer(id);
    }
}

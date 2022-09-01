package com.claseNueveMapper.app.service.impl;

import com.claseNueveMapper.app.dtos.request.CustomerDTO;
import com.claseNueveMapper.app.dtos.response.CustomerResponseDTO;
import com.claseNueveMapper.app.entity.Customer;
import com.claseNueveMapper.app.mapper.CustomerMapperImpl;
import com.claseNueveMapper.app.service.ICustomerService;


import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    //En este archivo haríamos las peticiones a la base de datos. Desde las implementaciones a través de la interfase.
    private CustomerMapperImpl customerMapperImpl = new CustomerMapperImpl();

//    @Override
//    public void insert(String nombre, String apellido) {
//        System.out.println("Insertando un nuevo cliente: " + nombre + " " + apellido);
//    }
//
//    @Override
//    public String update(String nombre, String apellido, Integer id) {
//        return "Actualizando datos de cliente: " + nombre + " " + apellido + " id " + id;
//    }
//
//    @Override
//    public void delete(Integer id) {
//        System.out.println("Borrando datos de cliente: id " + id);
//    }
//
//    @Override
//    public String listarTodos() {
//        return "Listando todos los clientes";
//    }
//
//    //En este archivo haríamos las peticiones a la base de datos. Desde las implementaciones a través de la interfase.
//    private EmployeeMapperImpl employeeMapperImpl = new EmployeeMapperImpl();

    @Override
    public void insertCustomer(Customer customer) {
        Customer customer1 = new Customer();
        customer1 = customer;
        System.out.println("Se inserta a cliente: " + customer1.toString());
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerDTO customerDTO, Integer id) {
        Customer updatedCustomer = new Customer();
        updatedCustomer.setName(/*customerDTO.getName()*/"Cambiar");
        updatedCustomer.setLastName(/*customerDTO.getLastName()*/"Cambiar");

        return customerMapperImpl.toEntityToDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        System.out.println("Borrando datos de cliente: id " + id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setName("Cristiano");
        customer1.setLastName("Ronaldo");
        List<Customer> listOfCustomers = new ArrayList<>();
        listOfCustomers.add(customer1);
        return listOfCustomers;
    }
}

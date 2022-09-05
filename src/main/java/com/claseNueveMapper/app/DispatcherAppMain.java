package com.claseNueveMapper.app;

import com.claseNueveMapper.app.controller.CustomerController;
import com.claseNueveMapper.app.controller.EmployeeController;
import com.claseNueveMapper.app.controller.PersonController;
import com.claseNueveMapper.app.dtos.request.CustomerDTO;
import com.claseNueveMapper.app.dtos.request.EmployeeDTO;
import com.claseNueveMapper.app.dtos.request.PersonDTO;
import com.claseNueveMapper.app.entity.Customer;
import com.claseNueveMapper.app.entity.Employee;
import com.claseNueveMapper.app.entity.Person;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DispatcherAppMain {
    public static void main(String[] args) {
        System.out.println("Clase 9");

        PersonController personController = new PersonController();
        EmployeeController employeeController = new EmployeeController();
        CustomerController customerController = new CustomerController();

        /*-----Person-----*/
//        PersonDTO personDTO = new PersonDTO();
//
//        Person person1 = new Person();
//        person1.setName("Nico");
//        person1.setLastName("Clemente");
//        Integer id1 = 31;
//
//        personDTO.setName("NicoModificado");
//        personDTO.setLastName("ClementeModificado");
//
//        personController.addPerson(person1);
//        System.out.println(personController.updatePerson(personDTO ,id1));
//        System.out.println(personController.listAllPersons());
//        personController.deletePerson(id1);
//        System.out.println("");

        /*-----Employee-----*/
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//
//        Employee employee1 = new Employee();
//        employee1.setName("Carlos");
//        employee1.setLastName("Clemente");
//        Integer id2 = 35;
//
//        employeeDTO.setName("CarlosModificado");
//        employeeDTO.setLastName("ClementeMod");
//
//        employeeController.addEmployee(employee1);
//        System.out.println(employeeController.updateEmployee(employeeDTO,id2));
//        System.out.println(employeeController.listAllEmployees());
//        employeeController.deleteEmployee(id2);
//        System.out.println("");

        /*-----Customer-----*/
//        CustomerDTO customerDTO = new CustomerDTO();
//
//        Customer customer1 = new Customer();
//        customer1.setName("Juan");
//        customer1.setLastName("Clemente");
//        Integer id3 = 38;
//
//        customerController.addCustomer(customer1);
//        System.out.println(customerController.updateCustomer(customerDTO,id3));
//        System.out.println(customerController.listAllCustomers());
//        customerController.deleteCustomer(id3);

        /*-----Connection SQL-----*/
//        List<Person> persons = personController.listAllPersons();
//        System.out.println("----------LIST OF PERSONS---------");
//        persons.forEach(person -> {
//            System.out.println("Persona = " + person);
//        });

//        List<Employee> employees = employeeController.listAllEmployees();
//        System.out.println("----------LIST OF EMPLOYEES---------");
//        employees.forEach(employee -> {
//            System.out.println("Employee = " + employee);
//        });

//        List<Customer> customers = customerController.listAllCustomers();
//        System.out.println("----------LIST OF CUSTOMERS---------");
//        customers.forEach(customer -> {
//            System.out.println("Customer = " + customer);
//        });

//        System.out.println("--------------------------------");
//        System.out.println("----------GET ONE PERSON---------");
//        System.out.println(personController.listOnePerson(1));

        System.out.println("----------GET ONE EMPLOYEE---------");
        System.out.println(personController.listOnePerson(1));

        System.out.println("----------GET ONE CUSTOMER---------");
        System.out.println(personController.listOnePerson(1));

//        System.out.println("--------------------------------");
//        System.out.println("----------INSERT PERSON---------");
//        Person personInsert1 = new Person("Mariano", "Romero", 27, "Formosa");
//        personController.addPerson(personInsert1);

//        System.out.println("----------INSERT EMPLOYEE---------");
//        Calendar calendar = Calendar.getInstance();
//        Employee employeeInsert1 = new Employee(calendar.getTime(), 870434.00, 1);
//        employeeController.addEmployee(employeeInsert1);

//        System.out.println("----------INSERT CUSTOMER---------");
//        Customer customerInsert1 = new Customer(true, 3);
//        customerController.addCustomer(customerInsert1);

//        System.out.println("--------------------------------");
//        System.out.println("----------DELETE PERSON---------");
//        personController.deletePerson(4);

//        System.out.println("----------DELETE EMPLOYEE---------");
//        employeeController.deleteEmployee(6);

//        System.out.println("----------DELETE CUSTOMER---------");
//        customerController.deleteCustomer(4);

//        System.out.println("--------------------------------");
//        System.out.println("----------UPDATE PERSON---------");
//        PersonDTO personUpdate1 = new PersonDTO("Juan", "Perez", 40, "Chaco");
//        System.out.println(personController.updatePerson(personUpdate1, 3));

//        System.out.println("----------UPDATE EMPLOYEE---------");
//        EmployeeDTO employeeUpdate1 = new EmployeeDTO(50000.00);
//        System.out.println(employeeController.updateEmployee(employeeUpdate1, 4));

//        System.out.println("----------UPDATE CUSTOMER---------");
//        CustomerDTO customerUpdate1 = new CustomerDTO(false);
//        System.out.println(customerController.updateCustomer(customerUpdate1, 1));

    }
}

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
import java.util.List;

public class DispatcherAppMain {
    public static void main(String[] args) {
        System.out.println("Clase 9");

        PersonController personController = new PersonController();
        EmployeeController employeeController = new EmployeeController();
        CustomerController customerController = new CustomerController();

//        /*-----Person-----*/
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
//
//        /*-----Employee-----*/
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
//
//        /*-----Customer-----*/
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
        List<Person> persons;

        persons = personController.listAllPersons();

        persons.forEach(person -> {
            System.out.println("persona = " + person);
        });



//      System.out.println("-------------------------");
//      System.out.println("----------DELETE---------");
//      personController.deletePerson(6);

//        System.out.println("-------------------------");
//        System.out.println("----------INSERT---------");
//        Person personInsert1 = new Person("Juan","Perez",40,"Chaco");
//        personController.addPerson(personInsert1);

        System.out.println("-------------------------");
        System.out.println("----------UPDATE---------");
        PersonDTO personUpdate1 = new PersonDTO("JuanMod","PerezMOD",40,"Chaco");
        System.out.println(personController.updatePerson(personUpdate1,7));

        persons = personController.listAllPersons();
        System.out.println("-------------------------");
        for(Person personOfList: persons) {
            System.out.println("persona = " + personOfList);
        }
    }
}

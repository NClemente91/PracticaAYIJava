package com.claseNueveMapper.app.service.impl;

import com.claseNueveMapper.app.dtos.request.EmployeeDTO;
import com.claseNueveMapper.app.dtos.response.EmployeeResponseDTO;
import com.claseNueveMapper.app.entity.Employee;
import com.claseNueveMapper.app.mapper.EmployeeMapperImpl;
import com.claseNueveMapper.app.service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    //En este archivo haríamos las peticiones a la base de datos. Desde las implementaciones a través de la interfase.
    private EmployeeMapperImpl employeeMapperImpl = new EmployeeMapperImpl();

    @Override
    public void insertEmployee(Employee employee) {
        Employee employee1 = new Employee();
        employee1 = employee;
        System.out.println("Se inserta a empleado: " + employee1.toString());
    }

    @Override
    public EmployeeResponseDTO updateEmployee(EmployeeDTO employeeDTO, Integer id) {
        Employee updatedEmployee = new Employee();
        updatedEmployee.setName(/*employeeDTO.getName()*/"Cambiar");
        updatedEmployee.setLastName(/*employeeDTO.getLastName()*/"Cambiar");

        return employeeMapperImpl.toEntityToDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        System.out.println("Borrando datos de empleado: id " + id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setName("Cristiano");
        employee1.setLastName("Ronaldo");
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(employee1);
        return listOfEmployees;
    }

}

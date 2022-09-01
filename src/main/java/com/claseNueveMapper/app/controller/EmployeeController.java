package com.claseNueveMapper.app.controller;

import com.claseNueveMapper.app.dtos.request.EmployeeDTO;
import com.claseNueveMapper.app.dtos.response.EmployeeResponseDTO;
import com.claseNueveMapper.app.entity.Employee;
import com.claseNueveMapper.app.service.IEmployeeService;
import com.claseNueveMapper.app.service.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    IEmployeeService iEmployeeService = new EmployeeServiceImpl();

    public void addEmployee(Employee employee) {
        iEmployeeService.insertEmployee(employee);
    }

    public void deleteEmployee(Integer id) {
        iEmployeeService.deleteEmployee(id);
    }

    public List<Employee> listAllEmployees() {
        return iEmployeeService.getAllEmployees();
    }

    public EmployeeResponseDTO updateEmployee(EmployeeDTO employeeDTO, Integer id) {
        return iEmployeeService.updateEmployee(employeeDTO, id);
    }

}

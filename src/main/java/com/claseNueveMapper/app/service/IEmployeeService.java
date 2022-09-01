package com.claseNueveMapper.app.service;

import com.claseNueveMapper.app.dtos.request.EmployeeDTO;
import com.claseNueveMapper.app.dtos.response.EmployeeResponseDTO;
import com.claseNueveMapper.app.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    void insertEmployee(Employee employee);

    EmployeeResponseDTO updateEmployee(EmployeeDTO employee, Integer id);

    void deleteEmployee(Integer id);

    List<Employee> getAllEmployees();
}

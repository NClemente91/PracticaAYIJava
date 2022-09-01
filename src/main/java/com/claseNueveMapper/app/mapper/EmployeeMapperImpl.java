package com.claseNueveMapper.app.mapper;

import com.claseNueveMapper.app.dtos.response.EmployeeResponseDTO;
import com.claseNueveMapper.app.entity.Employee;
import org.modelmapper.ModelMapper;

public class EmployeeMapperImpl {
    private ModelMapper modelMapper = new ModelMapper();

    public EmployeeResponseDTO toEntityToDto(Employee employeeInput) {

        return modelMapper.map(employeeInput, EmployeeResponseDTO.class);

    }
}

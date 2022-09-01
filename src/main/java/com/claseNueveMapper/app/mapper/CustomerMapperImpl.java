package com.claseNueveMapper.app.mapper;

import com.claseNueveMapper.app.dtos.response.CustomerResponseDTO;
import com.claseNueveMapper.app.entity.Customer;
import org.modelmapper.ModelMapper;

public class CustomerMapperImpl {
    private ModelMapper modelMapper = new ModelMapper();

    public CustomerResponseDTO toEntityToDto(Customer customerInput) {

        return modelMapper.map(customerInput, CustomerResponseDTO.class);

    }
}

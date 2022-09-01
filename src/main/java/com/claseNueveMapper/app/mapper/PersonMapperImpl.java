package com.claseNueveMapper.app.mapper;

import com.claseNueveMapper.app.dtos.response.PersonResponseDTO;
import com.claseNueveMapper.app.entity.Person;
import org.modelmapper.ModelMapper;

public class PersonMapperImpl {

    private ModelMapper modelMapper = new ModelMapper();

    public PersonResponseDTO toEntityToDto(Person personInput) {

        return modelMapper.map(personInput, PersonResponseDTO.class);

    }
}

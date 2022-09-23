package com.ayi.curso.rest.serv.app.mappers;

import com.ayi.curso.rest.serv.app.dtos.request.persons.PersonDTO;
import com.ayi.curso.rest.serv.app.dtos.response.persons.PersonResponseDTO;
import com.ayi.curso.rest.serv.app.entities.PersonEntity;

public interface IPersonMapper {

    PersonResponseDTO entityToDto(PersonEntity entity);

    PersonEntity dtoToEntity(PersonDTO dto);

    PersonEntity toEntityByRequest(PersonDTO dto);

}
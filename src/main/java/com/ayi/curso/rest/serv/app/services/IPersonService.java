package com.ayi.curso.rest.serv.app.services;

import com.ayi.curso.rest.serv.app.dtos.response.persons.PersonResponseDTO;

import java.util.List;

public interface IPersonService {
    List<PersonResponseDTO> findAllPersons();

    PersonResponseDTO findPersonById(Long idPerson);

    PersonResponseDTO findPersonByName(String name, String ape);
}

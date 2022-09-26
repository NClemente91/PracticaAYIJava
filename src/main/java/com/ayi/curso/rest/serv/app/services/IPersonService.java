package com.ayi.curso.rest.serv.app.services;

import com.ayi.curso.rest.serv.app.dtos.request.persons.PersonDTO;
import com.ayi.curso.rest.serv.app.dtos.response.persons.PersonResponseDTO;

import java.util.List;

public interface IPersonService {

    List<PersonResponseDTO> findAllPersons(int pageNumber, int pageSize, String sortBy, String sortDir);

    PersonResponseDTO findPersonById(Long idPerson);

    PersonResponseDTO findPersonByName(String name, String ape);

    void deletePersonById(Long idPerson);

    PersonResponseDTO addPerson(PersonDTO personDTO);

    void updatePersonById(Long id, PersonDTO person);
}

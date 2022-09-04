package com.claseNueveMapper.app.service;

import com.claseNueveMapper.app.dtos.request.PersonDTO;
import com.claseNueveMapper.app.dtos.response.PersonResponseDTO;
import com.claseNueveMapper.app.entity.Person;

import java.util.List;

public interface IPersonService {
    void insertPerson(Person person);

    PersonResponseDTO updatePerson(PersonDTO person, Integer id);

    void deletePerson(Integer id);

    List<Person> getAllPersons();

    Person getOnePerson(Integer id);
}

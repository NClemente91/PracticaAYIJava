package com.claseNueveMapper.app.controller;

import com.claseNueveMapper.app.dtos.request.PersonDTO;
import com.claseNueveMapper.app.dtos.response.PersonResponseDTO;
import com.claseNueveMapper.app.entity.Person;
import com.claseNueveMapper.app.service.IPersonService;
import com.claseNueveMapper.app.service.impl.PersonServiceImpl;

import java.util.List;

public class PersonController {

    IPersonService iPersonService = new PersonServiceImpl();

    public void addPerson(Person person) {
        iPersonService.insertPerson(person);
    }

    public void deletePerson(Integer id) {
        iPersonService.deletePerson(id);
    }

    public List<Person> listAllPersons() {
        return iPersonService.getAllPersons();
    }

    public PersonResponseDTO updatePerson(PersonDTO person, Integer id) {
        return iPersonService.updatePerson(person, id);
    }

    public Person listOnePerson(Integer id) {
        return iPersonService.getOnePerson(id);
    }
}

package com.ayi.curso.rest.serv.app.services.impl;

import com.ayi.curso.rest.serv.app.dtos.request.persons.PersonDTO;
import com.ayi.curso.rest.serv.app.dtos.response.persons.PersonResponseDTO;
import com.ayi.curso.rest.serv.app.entities.PersonEntity;
import com.ayi.curso.rest.serv.app.mappers.IPersonMapper;
import com.ayi.curso.rest.serv.app.repositories.IPersonRepository;
import com.ayi.curso.rest.serv.app.services.IPersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service //Para que pueda ser inyectado desde otro lugar
@Slf4j
@Transactional //Hace el trabajo de JPA (commit - begin - rollback - etc)
public class PersonServiceImpl extends Exception implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    private IPersonMapper personMapper;

    @Override
    public List<PersonResponseDTO> findAllPersons() {

        List<PersonResponseDTO> personResponseDTOs;

        List<PersonEntity> personEntities = personRepository.findAll();

        personResponseDTOs = personEntities.stream()
                .map(lt -> new PersonResponseDTO(
                        lt.getIdPerson(),
                        lt.getFirstName(),
                        lt.getLastName(),
                        lt.getTypeDocument(),
                        lt.getNumberDocument(),
                        lt.getDateBorn(),
                        lt.getDateCreated(),
                        lt.getDateModified()
                ))
                .collect(Collectors.toList());

        return personResponseDTOs;
    }

    @Override
    public PersonResponseDTO findPersonById(Long idPerson){

        PersonResponseDTO personResponseDTO;

        Optional<PersonEntity> entity = personRepository.findById(idPerson);


        if(!entity.isPresent()) {
            throw new RuntimeException("Error no existe el id de persona buscado");
        }

        personResponseDTO = personMapper.entityToDto(entity.get());
        return personResponseDTO;

    }

    @Override
    public PersonResponseDTO findPersonByName(String name, String ape){

        PersonResponseDTO personResponseDTO;

        PersonEntity entity = personRepository.getPersonByName(name, ape);

        personResponseDTO = personMapper.entityToDto(entity);
        return personResponseDTO;

    }

    @Override
    public void deletePersonById(Long idPerson){

        Optional<PersonEntity> entity = personRepository.findById(idPerson);

        if(!entity.isPresent()) {
            throw new RuntimeException("Error no existe el id de persona buscado");
        }

        personRepository.delete(entity.get());

        System.out.println("Persona con id " + idPerson + " eliminada correctamente.");

    }

    @Override
    public PersonResponseDTO addPerson(PersonDTO personDTO){

        PersonEntity personEntity = personMapper.dtoToEntity(personDTO);

        PersonEntity personSaved = personRepository.save(personEntity);

        return personMapper.entityToDto(personSaved);

    }

}

package com.ayi.curso.rest.serv.app.mappers.impl;

        import com.ayi.curso.rest.serv.app.dtos.request.persons.PersonDTO;
        import com.ayi.curso.rest.serv.app.dtos.response.persons.PersonResponseDTO;
        import com.ayi.curso.rest.serv.app.dtos.response.persons.PersonResponseDTOFull;
        import com.ayi.curso.rest.serv.app.entities.PersonEntity;
        import com.ayi.curso.rest.serv.app.mappers.IPersonMapper;
//        import com.ayi.test.rest.serv.app.dto.request.persons.PersonDTO;
//        import com.ayi.test.rest.serv.app.dto.response.persons.PersonResponseDTO;
//        import com.ayi.test.rest.serv.app.entity.PersonEntity;
//        import com.ayi.test.rest.serv.app.mapper.IPersonMapper;
        import lombok.AllArgsConstructor;
        import org.modelmapper.ModelMapper;
        import org.springframework.stereotype.Component;

        import java.util.ArrayList;
        import java.util.List;

@Component
@AllArgsConstructor
public class PersonMapperImpl extends Exception implements IPersonMapper {

    private final ModelMapper modelMapper;
    @Override
    public PersonResponseDTO entityToResponseDto(PersonEntity entity) {

        PersonResponseDTO personResponseDTO = new PersonResponseDTO();
        modelMapper.map(entity, personResponseDTO);
        return personResponseDTO;
    }
    @Override
    public PersonEntity requestDtoToEntity(PersonDTO dto) {
        PersonEntity personEntity = new PersonEntity();
        modelMapper.map(dto, personEntity);
        return personEntity;
    }

    @Override
    public PersonResponseDTOFull listPersonDTOs(List<PersonEntity> listPersonEntities) {

        PersonResponseDTOFull listPersonResponseFullDTOs = new PersonResponseDTOFull();
        List<PersonResponseDTO> listPersonResponseDTOS = new ArrayList<>();
        listPersonEntities.forEach((PersonEntity personEntity) -> {
            PersonResponseDTO listPersonResponseDTO =
                    PersonResponseDTO.builder()
                            .idPerson(personEntity.getIdPerson())
                            .firstName(personEntity.getFirstName())
                            .lastName(personEntity.getLastName())
                            .typeDocument(personEntity.getTypeDocument())
                            .numberDocument(personEntity.getNumberDocument())
                            .dateBorn(personEntity.getDateBorn())
                            .dateCreated(personEntity.getDateCreated())
                            .dateModified(personEntity.getDateModified())
                            .build();
            listPersonResponseDTOS.add(listPersonResponseDTO);

        });

        listPersonResponseFullDTOs.setPersonResponseDTO(listPersonResponseDTOS);

        return listPersonResponseFullDTOs;
    }

}
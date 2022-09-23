package com.ayi.curso.rest.serv.app.mappers.impl;

        import com.ayi.curso.rest.serv.app.dtos.request.persons.PersonDTO;
        import com.ayi.curso.rest.serv.app.dtos.response.persons.PersonResponseDTO;
        import com.ayi.curso.rest.serv.app.entities.PersonEntity;
        import com.ayi.curso.rest.serv.app.mappers.IPersonMapper;
//        import com.ayi.test.rest.serv.app.dto.request.persons.PersonDTO;
//        import com.ayi.test.rest.serv.app.dto.response.persons.PersonResponseDTO;
//        import com.ayi.test.rest.serv.app.entity.PersonEntity;
//        import com.ayi.test.rest.serv.app.mapper.IPersonMapper;
        import lombok.AllArgsConstructor;
        import org.modelmapper.ModelMapper;
        import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonMapperImpl extends Exception implements IPersonMapper {

    private final ModelMapper modelMapper;
    @Override
    public PersonResponseDTO entityToDto(PersonEntity entity) {

        PersonResponseDTO personResponseDTO = new PersonResponseDTO();
        modelMapper.map(entity, personResponseDTO);
        return personResponseDTO;
    }
    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity personEntity = new PersonEntity();
        modelMapper.map(dto, personEntity);
        return personEntity;
    }

    @Override
    public PersonEntity toEntityByRequest(PersonDTO dto) {

        PersonEntity personEntity = new PersonEntity();
        modelMapper.map(dto, personEntity);
        return personEntity;
    }

}
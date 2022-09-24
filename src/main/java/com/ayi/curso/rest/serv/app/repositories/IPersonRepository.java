package com.ayi.curso.rest.serv.app.repositories;

import com.ayi.curso.rest.serv.app.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query("Select PE from PersonEntity PE where PE.firstName = :name and PE.lastName = :ape")
    Optional<PersonEntity> getPersonByName(@Param("name") String name, @Param("ape") String ape);

    //Esto es de acuerdo al atributo que esté en la entidad
    PersonEntity findByNumberDocument(Integer numberDocument);

}

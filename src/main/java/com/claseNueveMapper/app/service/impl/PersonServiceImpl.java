package com.claseNueveMapper.app.service.impl;

import com.claseNueveMapper.app.configuration.ConnectionDB;
import com.claseNueveMapper.app.constants.Constants;
import com.claseNueveMapper.app.dtos.request.PersonDTO;
import com.claseNueveMapper.app.dtos.response.PersonResponseDTO;
import com.claseNueveMapper.app.entity.Person;
import com.claseNueveMapper.app.mapper.PersonMapperImpl;
import com.claseNueveMapper.app.service.IPersonService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements IPersonService {

    //En este archivo haríamos las peticiones a la base de datos. Desde las implementaciones a través de la interfase.
    private ConnectionDB connectionDB = new ConnectionDB();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Person person = null;

    private PersonMapperImpl personaMapperImpl = new PersonMapperImpl();

    @Override
    public void insertPerson(Person person) {

        try {
            conn = connectionDB.getConnection();

            stmt = conn.prepareStatement(Constants.SQL_INSERT_PERSON);

            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastName());
            stmt.setInt(3,person.getAge());
            stmt.setString(4,person.getAddress());

            stmt.executeUpdate();

            System.out.println("Se ingresó a la persona correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connectionDB.close(rs);
                connectionDB.close(stmt);
                connectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public PersonResponseDTO updatePerson(PersonDTO personDTO, Integer id) {

        Integer resultUpdate;

        try {
            conn = connectionDB.getConnection();

            stmt = conn.prepareStatement(Constants.SQL_UPDATE_PERSON);

            stmt.setString(1, personDTO.getName());
            stmt.setString(2, personDTO.getLastName());
            stmt.setInt(3,personDTO.getAge());
            stmt.setString(4,personDTO.getAddress());
            stmt.setInt(5, id);

            resultUpdate = stmt.executeUpdate();

            System.out.println(resultUpdate);

            PersonResponseDTO personResponseDTO = new PersonResponseDTO();
            return personResponseDTO;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connectionDB.close(stmt);
                connectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void deletePerson(Integer id) {

        Integer resultDelete;

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_DELETE_PERSON);

            stmt.setInt(1,id);

            resultDelete = stmt.executeUpdate();

            if(resultDelete==0){
                System.out.println("No se encontró registro con id: " + id);
            } else {
                System.out.println("Borrando datos de persona: id " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connectionDB.close(stmt);
                connectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_SELECT_PERSON);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPerson = rs.getInt("id_person");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                Integer age = rs.getInt("age");
                String address = rs.getString("address");

                person = new Person(idPerson, name, lastName, age, address);

                persons.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connectionDB.close(rs);
                connectionDB.close(stmt);
                connectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return persons;
    }
}

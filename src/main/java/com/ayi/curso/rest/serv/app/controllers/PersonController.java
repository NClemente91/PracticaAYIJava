package com.ayi.curso.rest.serv.app.controllers;

import com.ayi.curso.rest.serv.app.dtos.request.persons.PersonDTO;
import com.ayi.curso.rest.serv.app.dtos.response.persons.PersonResponseDTO;
import com.ayi.curso.rest.serv.app.dtos.response.persons.PersonResponseDTOFull;
import com.ayi.curso.rest.serv.app.services.IPersonService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AllArgsConstructor
@Api(value = "Person Api", tags = {"Person Service"}) //Relacionado con Swagger
@RestController
//Para que pueda ser accedido desde afuera de la api. Con controller solo podemos hacerlo de manera interna
@RequestMapping(value = "/persons", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j //Lo vemos más adelante
public class PersonController {
    private IPersonService personService;

    /**
     * GET ALL PERSONS
     * @param pageNumber
     * @param pageSize
     * @param sortBy
     * @param sortDir
     * @return List of persons
     */
    @GetMapping(value = "/getAllPersons")
    @ApiOperation(
            value = "Retrieves all Lists Persons",
            httpMethod = "GET",
            response = PersonResponseDTO[].class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with basic information about persons",
                    response = PersonResponseDTO[].class),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<List<PersonResponseDTO>> getAllPersons(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "idPerson", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {

        List<PersonResponseDTO> personResponseDTOs = personService.findAllPersons(pageNumber, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(personResponseDTOs);

    }


    @GetMapping(value = "/getAllPersons/{page}/{size}")
    @ApiOperation(
            value = "Retrieves all Lists Persons",
            httpMethod = "GET",
            response = PersonResponseDTOFull.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with basic information about persons",
                    response = PersonResponseDTOFull.class),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<PersonResponseDTOFull> getAllPersonsForPage(
            @ApiParam(value = "page to display", required = true, example = "1")
            @PathVariable(name = "page") Integer page,
            @ApiParam(value = "number of items per request", required = true, example = "1")
            @PathVariable(name = "size") Integer size)  {

        PersonResponseDTOFull personResponseDTOs = personService.findAllPersonsForPage(page, size);
        return ResponseEntity.ok(personResponseDTOs);

    }

    /**
     * GET PERSON BY ID
     * @param id
     * @return Person
     */
    @GetMapping(value = "/getPersonById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to List Master by Id",
            httpMethod = "GET",
            response = PersonResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with basic information for this Lists Master by Id"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<PersonResponseDTO> getPersonById(
            @ApiParam(name = "id", required = true, value = "Person Id", example = "1")
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(personService.findPersonById(id));

    }

    @GetMapping(value = "/getPersonByName/{nombre}/{apellido}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to List Master by Name and LastName",
            httpMethod = "GET",
            response = PersonResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with basic information for this Lists Master by Id"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<PersonResponseDTO> getPersonByNameAndLastName(
            @ApiParam(name = "nombre", required = true, value = "Nombre", example = "1")
            @PathVariable("nombre") String nombre,
            @ApiParam(name = "apellido", required = true, value = "Apellido", example = "1")
            @PathVariable("apellido") String apellido) {

        return ResponseEntity.ok(personService.findPersonByName(nombre, apellido));

    }

    /**
     * Método CREATE
     * @param person
     * @return Created Person.
     */
    @PostMapping(value = "/addPerson", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to List Master by Id",
            httpMethod = "POST",
            response = PersonResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with basic information for this Lists Master by Id"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<PersonResponseDTO> addPerson(
            @ApiParam(name = "person", required = true, value = "Person", example = "1")
            @RequestBody PersonDTO person) {

        //return ResponseEntity.ok(personService.addPerson(person));
        //Otra forma de armar la respuesta HTTP
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }

    /**
     * Método UPDATE
     * @param id
     * @param person
     * @return Updated Person
     */
    @PutMapping(value = "/updatePerson/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to List Master by Id",
            httpMethod = "PUT",
            response = PersonResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with basic information for this Lists Master by Id"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<Void> updatePerson(
            @ApiParam(name = "id person", required = true, example = "1") @PathVariable Long id,
            @RequestBody PersonDTO person) {

        personService.updatePersonById(id, person);

        return ResponseEntity.ok().build();
    }

    /**
     * Método DELETE
     * @param id
     * @return void
     */
    @DeleteMapping(value = "/deleteById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Delete data associated to List Master by Id",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 204,
                    message = "Borrado correctamente"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    //Response entity vacía para poder mandar una respuesta http
    //Response Entity <?> - Me permite crear la estructura de respuesta dinámica
    public ResponseEntity<Void> deletePersonById(
            @ApiParam(name = "id", required = true, value = "Person Id", example = "1")
            @PathVariable("id") Long id) {

        personService.findPersonById(id);

        //Con esta línea nos aseguramos una respuesta http
        return ResponseEntity.noContent().build();

    }

}

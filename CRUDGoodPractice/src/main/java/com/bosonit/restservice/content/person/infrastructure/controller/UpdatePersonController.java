package com.bosonit.restservice.content.person.infrastructure.controller;

import com.bosonit.restservice.content.person.application.port.UpdatePersonPort;
import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.person.infrastructure.controller.dto.input.PersonInputDTO;
import com.bosonit.restservice.content.person.infrastructure.controller.dto.output.PersonOutputDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("api/person")
public class UpdatePersonController {

    @Autowired
    private UpdatePersonPort updatePersonPort;

    @PutMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> update(
            @PathVariable int id,
            @Valid @RequestBody PersonInputDTO personInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SavePerson savePersona = personInputDTO.persona(new SavePerson());
        Person updatePerson;

        try {
            updatePerson = updatePersonPort.update(id, savePersona);
        } catch (Exception e) {
            throw new NotFoundException("Person with id " + id + " not found");
        }

        return new ResponseEntity<>(new PersonOutputDTO(updatePerson), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<PersonOutputDTO> update(
            @PathVariable int id,
            @RequestParam(required = false) String user,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String company_email,
            @RequestParam(required = false) String personal_email,
            @RequestParam(required = false) String image_url,
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) Date created_date,
            @RequestParam(required = false) Date termination_date)
            throws Exception {
        if (user == null && password == null && name == null && surname == null &&
                city == null && company_email == null && personal_email == null &&
                image_url == null && active == null && created_date == null &&
                termination_date == null) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "All the data can't be NULL");
        }

        SavePerson savePersona = new SavePerson(user, password, name, surname, city,
                company_email, personal_email, image_url, active, created_date, termination_date);
        Person updatePerson;

        try {
            updatePerson = updatePersonPort.update(id, savePersona);
        } catch (Exception e) {
            throw new NotFoundException("Person with id " + id + " not found");
        }

        return new ResponseEntity<>(new PersonOutputDTO(updatePerson), HttpStatus.OK);
    }
}

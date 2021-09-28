package com.bosonit.restservice.content.person.infrastructure.controller;

import com.bosonit.restservice.content.person.application.port.CreatePersonPort;
import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.person.infrastructure.controller.dto.input.PersonInputDTO;
import com.bosonit.restservice.content.person.infrastructure.controller.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("api/person")
public class CreatePersonController {

    @Autowired
    private CreatePersonPort createPersonPort;

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> create(
            @Valid @RequestBody PersonInputDTO personInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SavePerson savePersona = personInputDTO.persona(new SavePerson());
        Person createPerson = createPersonPort.create(savePersona);
        return new ResponseEntity<>(new PersonOutputDTO(createPerson), HttpStatus.CREATED);
    }
}

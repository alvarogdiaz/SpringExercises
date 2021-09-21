package com.bosonit.restservice.content.persona.infrastructure.controller;

import com.bosonit.restservice.content.persona.application.port.CreatePersonaPort;
import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@RestController
@RequestMapping("api/persona")
public class CreatePersonaController {

    @Autowired
    private CreatePersonaPort createPersonaPort;

    @RequestMapping(method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> create(
            @Valid @RequestBody PersonaInputDTO personaInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(errors.getFieldError().getDefaultMessage(),
                    HttpStatus.BAD_REQUEST);
        }
        SavePersona savePersona = personaInputDTO.persona(new SavePersona());
        Persona createPersona = createPersonaPort.create(savePersona);
        return new ResponseEntity<>(new PersonaOutputDTO(createPersona), HttpStatus.CREATED);
    }
}

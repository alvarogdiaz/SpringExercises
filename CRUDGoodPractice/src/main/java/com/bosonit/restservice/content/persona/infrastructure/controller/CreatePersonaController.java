package com.bosonit.restservice.content.persona.infrastructure.controller;

import com.bosonit.restservice.content.persona.application.port.CreatePersonaPort;
import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("api/persona")
public class CreatePersonaController {

    @Autowired
    private CreatePersonaPort createPersonaPort;

    @RequestMapping(method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<PersonaOutputDTO> create(
            @RequestBody PersonaInputDTO personaInputDTO)
            throws Exception {
        SavePersona savePersona = personaInputDTO.persona(new SavePersona());
        Persona createPersona = createPersonaPort.create(savePersona);
        return new ResponseEntity<>(new PersonaOutputDTO(createPersona), HttpStatus.CREATED);
    }
}

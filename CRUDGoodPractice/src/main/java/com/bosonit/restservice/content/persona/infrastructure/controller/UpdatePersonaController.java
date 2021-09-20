package com.bosonit.restservice.content.persona.infrastructure.controller;

import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.SavePersonaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("api/persona")
public class UpdatePersonaController {

    @Autowired
    private SavePersonaPort savePersonaPort;

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<PersonaOutputDTO> update(
            @PathVariable int id,
            @RequestBody PersonaInputDTO personaInputDTO)
            throws Exception {
        SavePersona savePersona = personaInputDTO.persona(new SavePersona());
        savePersona.setId(id);
        Persona updatePersona = savePersonaPort.save(savePersona);
        return new ResponseEntity<>(new PersonaOutputDTO(updatePersona), HttpStatus.OK);
    }
}

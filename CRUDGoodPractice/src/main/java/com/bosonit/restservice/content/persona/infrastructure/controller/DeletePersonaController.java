package com.bosonit.restservice.content.persona.infrastructure.controller;

import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.DeletePersonaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("api/persona")
public class DeletePersonaController {

    @Autowired
    private DeletePersonaPort deletePersonaPort;

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<HttpStatus> delete(
            @PathVariable int id)
            throws Exception {
        deletePersonaPort.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping(method = RequestMethod.DELETE)
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<HttpStatus> deleteAll()
            throws Exception {
        deletePersonaPort.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

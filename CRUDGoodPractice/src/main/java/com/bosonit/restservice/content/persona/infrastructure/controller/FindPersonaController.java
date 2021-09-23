package com.bosonit.restservice.content.persona.infrastructure.controller;

import com.bosonit.restservice.content.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.FindPersonaPort;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/persona")
public class FindPersonaController {

    @Autowired
    private FindPersonaPort findPersonaPort;

    @GetMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<PersonaOutputDTO> findById(
            @PathVariable int id)
            throws Exception {
        return new ResponseEntity<>(new PersonaOutputDTO(findPersonaPort.findById(id)),
                HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<List<PersonaOutputDTO>> findByName(
            @PathVariable String name)
            throws Exception {
        return new ResponseEntity<>(findPersonaPort.findByName(name).stream()
                .map(PersonaOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("user/{user}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<List<PersonaOutputDTO>> findByUser(
            @PathVariable String user)
            throws Exception {
        return new ResponseEntity<>(findPersonaPort.findByUser(user).stream()
                .map(PersonaOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<List<PersonaOutputDTO>> findAll()
            throws Exception {
        return new ResponseEntity<>(findPersonaPort.findAll().stream()
                .map(PersonaOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}

package com.bosonit.restservice.content.person.infrastructure.controller;

import com.bosonit.restservice.content.person.infrastructure.controller.dto.output.PersonOutputDTO;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/person")
public class FindPersonController {

    private FindPersonPort findPersonPort;
    private Environment environment;

    @GetMapping("{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<PersonOutputDTO> findById(
            @PathVariable int id)
            throws Exception {
        return new ResponseEntity<>(new PersonOutputDTO(findPersonPort.findById(id)),
                HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<PersonOutputDTO>> findByName(
            @PathVariable String name)
            throws Exception {
        return new ResponseEntity<>(findPersonPort.findByName(name).stream()
                .map(PersonOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("user/{user}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<PersonOutputDTO>> findByUser(
            @PathVariable String user)
            throws Exception {
        return new ResponseEntity<>(findPersonPort.findByUser(user).stream()
                .map(PersonOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<PersonOutputDTO>> findAll()
            throws Exception {
        return new ResponseEntity<>(findPersonPort.findAll().stream()
                .map(PersonOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}

package com.bosonit.restservice.content.person.infrastructure.controller;

import com.bosonit.restservice.content.person.infrastructure.repository.port.DeletePersonPort;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/person")
public class DeletePersonController {

    @Autowired
    private DeletePersonPort deletePersonPort;

    @DeleteMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> delete(
            @PathVariable int id)
            throws Exception {
        try {
            deletePersonPort.delete(id);
        } catch (Exception e) {
            throw new NotFoundException("Person with id " + id + " not found");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> deleteAll()
            throws Exception {
        deletePersonPort.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

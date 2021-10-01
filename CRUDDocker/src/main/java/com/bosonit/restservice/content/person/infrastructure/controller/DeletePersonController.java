package com.bosonit.restservice.content.person.infrastructure.controller;

import com.bosonit.restservice.content.person.infrastructure.repository.port.DeletePersonPort;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@AllArgsConstructor
@RequestMapping("api/person")
public class DeletePersonController {

    private DeletePersonPort deletePersonPort;

    @DeleteMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> delete(
            @PathVariable int id)
            throws Exception {
        try {
            deletePersonPort.delete(id);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Delete the student or teacher associated first");
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

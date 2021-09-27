package com.bosonit.restservice.content.student.infrastructure.controller;

import com.bosonit.restservice.content.student.infrastructure.repository.port.DeleteStudentPort;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class DeleteStudentController {

    @Autowired
    private DeleteStudentPort deleteStudentPort;

    @DeleteMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> delete(
            @PathVariable String id)
            throws Exception {
        try {
            deleteStudentPort.delete(id);
        } catch (Exception e) {
            throw new NotFoundException("Person with id " + id + " not found");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> deleteAll()
            throws Exception {
        deleteStudentPort.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

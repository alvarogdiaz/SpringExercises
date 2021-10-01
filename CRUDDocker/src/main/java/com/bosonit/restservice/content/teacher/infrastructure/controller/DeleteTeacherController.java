package com.bosonit.restservice.content.teacher.infrastructure.controller;

import com.bosonit.restservice.content.teacher.infrastructure.repository.port.DeleteTeacherPort;
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
@RequestMapping("api/teacher")
public class DeleteTeacherController {

    @Autowired
    private DeleteTeacherPort deleteTeacherPort;

    @DeleteMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> delete(
            @PathVariable int id)
            throws Exception {
        try {
            deleteTeacherPort.delete(id);
        } catch (Exception e) {
            throw new NotFoundException("Profesor with id " + id + " not found");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> deleteAll()
            throws Exception {
        deleteTeacherPort.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.bosonit.restservice.content.subject.infrastructure.controller;

import com.bosonit.restservice.content.subject.infrastructure.repository.port.DeleteSubjectPort;
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
@RequestMapping("api/subject")
public class DeleteSubjectController {

    @Autowired
    private DeleteSubjectPort deleteSubjectPort;

    @DeleteMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> delete(
            @PathVariable String id)
            throws Exception {
        try {
            deleteSubjectPort.delete(id);
        } catch (Exception e) {
            throw new NotFoundException("Subject with id " + id + " not found");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> deleteAll()
            throws Exception {
        deleteSubjectPort.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

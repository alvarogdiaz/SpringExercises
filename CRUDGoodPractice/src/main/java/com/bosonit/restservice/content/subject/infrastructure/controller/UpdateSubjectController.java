package com.bosonit.restservice.content.subject.infrastructure.controller;

import com.bosonit.restservice.content.subject.application.port.UpdateSubjectPort;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.input.SimpleSubjectInputDTO;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.output.SubjectOutputDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("api/subject")
public class UpdateSubjectController {

    @Autowired
    private UpdateSubjectPort updateSubjectPort;

    @PutMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> update(
            @PathVariable String id,
            @Valid @RequestBody SimpleSubjectInputDTO subjectInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SaveSubject saveSubject = subjectInputDTO.subject(new SaveSubject());
        Subject updateSubject;

        try {
            updateSubject = updateSubjectPort.update(id, saveSubject);
        } catch (Exception e) {
            throw new NotFoundException("Subject with id " + id + " not found");
        }

        return new ResponseEntity<>(new SubjectOutputDTO(updateSubject), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<SubjectOutputDTO> update(
            @PathVariable String id,
            @RequestParam(required = false) String comments,
            @RequestParam(required = false) String asignatura,
            @RequestParam(required = false) Date finish_date,
            @RequestParam(required = false) Date initial_date)
            throws Exception {
        if (asignatura == null && comments == null &&
                finish_date == null && initial_date == null) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "All the data can't be NULL");
        }

        SaveSubject saveSubject = new SaveSubject(asignatura, comments, initial_date, finish_date);
        Subject updateSubject;

        try {
            updateSubject = updateSubjectPort.update(id, saveSubject);
        } catch (Exception e) {
            throw new NotFoundException("Subject with id " + id + " not found");
        }

        return new ResponseEntity<>(new SubjectOutputDTO(updateSubject), HttpStatus.OK);
    }
}

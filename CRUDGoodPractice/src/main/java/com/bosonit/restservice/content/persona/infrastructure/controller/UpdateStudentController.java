package com.bosonit.restservice.content.persona.infrastructure.controller;

import com.bosonit.restservice.content.persona.application.port.UpdateStudentPort;
import com.bosonit.restservice.content.persona.domain.Student;
import com.bosonit.restservice.content.persona.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.output.StudentOutputDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("api/student")
public class UpdateStudentController {

    @Autowired
    private UpdateStudentPort updateStudentPort;

    @PutMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> update(
            @PathVariable String id,
            @Valid @RequestBody StudentInputDTO studentInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SaveStudent saveStudent = studentInputDTO.student(new SaveStudent());
        Student updateStudent;

        try {
            updateStudent = updateStudentPort.update(id, studentInputDTO.getId_persona(), saveStudent);
        } catch (Exception e) {
            throw new NotFoundException("Student with id " + id + " not found");
        }

        return new ResponseEntity<>(new StudentOutputDTO(updateStudent), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<StudentOutputDTO> update(
            @PathVariable String id,
            @RequestParam(required = false) Integer id_persona,
            @RequestParam(required = false) Integer num_hours_week,
            @RequestParam(required = false) String comments,
            @RequestParam(required = false) String branch)
            throws Exception {
        if (id_persona == null && branch == null && comments == null && num_hours_week == null) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "All the data can't be NULL");
        }

        SaveStudent saveStudent = new SaveStudent(num_hours_week, comments, branch);
        Student updateStudent;

        try {
            updateStudent = (id_persona == null) ?
                    updateStudentPort.update(id, saveStudent) :
                    updateStudentPort.update(id, id_persona, saveStudent);
        } catch (Exception e) {
            throw new NotFoundException("Student with id " + id + " not found");
        }

        return new ResponseEntity<>(new StudentOutputDTO(updateStudent), HttpStatus.OK);
    }
}

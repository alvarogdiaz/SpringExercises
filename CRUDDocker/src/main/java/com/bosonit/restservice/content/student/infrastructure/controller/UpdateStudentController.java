package com.bosonit.restservice.content.student.infrastructure.controller;

import com.bosonit.restservice.content.student.application.port.UpdateStudentPort;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.student.infrastructure.controller.dto.input.SimpleStudentInputDTO;
import com.bosonit.restservice.content.student.infrastructure.controller.dto.output.StudentOutputDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("api/student")
public class UpdateStudentController {

    @Autowired
    private UpdateStudentPort updateStudentPort;

    @PutMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> update(
            @PathVariable int id,
            @Valid @RequestBody SimpleStudentInputDTO studentInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SaveStudent saveStudent = studentInputDTO.student(new SaveStudent());
        Student updateStudent;

        try {
            updateStudent = updateStudentPort.update(id, studentInputDTO.getId_persona(), null, saveStudent);
        } catch (Exception e) {
            throw new NotFoundException("Student with id " + id + " not found");
        }

        return new ResponseEntity<>(new StudentOutputDTO(updateStudent), HttpStatus.OK);
    }

    @PutMapping("subject/{id}/{subject}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<StudentOutputDTO> addSubject(
            @PathVariable(name = "id") int id_student,
            @PathVariable(name = "subject") int id_subject)
            throws Exception {
        Student student = updateStudentPort.addSubjects(id_student, new ArrayList<Integer>(Arrays.asList(id_subject)));
        return new ResponseEntity<>(new StudentOutputDTO(student), HttpStatus.OK);
    }

    @PutMapping("subject/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<StudentOutputDTO> addSubjects(
            @PathVariable(name = "id") int id_student,
            @RequestParam Integer[] id_subjects)
            throws Exception {
        Student student = updateStudentPort.addSubjects(id_student, new ArrayList<Integer>( Arrays.asList(id_subjects)));
        return new ResponseEntity<>(new StudentOutputDTO(student), HttpStatus.OK);
    }

    @PutMapping("unsubscribe/{id}/{subject}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<StudentOutputDTO> unsubscribeSubject(
            @PathVariable(name = "id") int id_student,
            @PathVariable(name = "subject") int id_subject)
            throws Exception {
        Student student = updateStudentPort.unsubscribeSubjects(id_student, new ArrayList<Integer>(Arrays.asList(id_subject)));
        return new ResponseEntity<>(new StudentOutputDTO(student), HttpStatus.OK);
    }

    @PutMapping("unsubscribe/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<StudentOutputDTO> unsubscribeSubjects(
            @PathVariable(name = "id") int id_student,
            @RequestParam Integer[] id_subjects)
            throws Exception {
        Student student = updateStudentPort.unsubscribeSubjects(id_student, new ArrayList<Integer>(Arrays.asList(id_subjects)));
        return new ResponseEntity<>(new StudentOutputDTO(student), HttpStatus.OK);
    }

    @PutMapping("teacher/{id}/{teacher}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<StudentOutputDTO> teacher(
            @PathVariable(name = "id") int id_student,
            @PathVariable(name = "teacher") int id_teacher)
            throws Exception {
        Student student = updateStudentPort.teacher(id_student, id_teacher);
        return new ResponseEntity<>(new StudentOutputDTO(student), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<StudentOutputDTO> update(
            @PathVariable int id,
            @RequestParam(required = false) Integer id_persona,
            @RequestParam(required = false) Integer num_hours_week,
            @RequestParam(required = false) String comments,
            @RequestParam(required = false) String branch,
            @RequestParam(required = false) Integer id_profesor)
            throws Exception {
        if (id_persona == null && branch == null && comments == null
                && num_hours_week == null && id_profesor == null) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "All the data can't be NULL");
        }

        SaveStudent saveStudent = new SaveStudent(num_hours_week, comments, branch);
        Student updateStudent;

        try {
            updateStudent = updateStudentPort.update(id, id_persona, id_profesor, saveStudent);
        } catch (Exception e) {
            throw new NotFoundException("Student with id " + id + " not found");
        }

        return new ResponseEntity<>(new StudentOutputDTO(updateStudent), HttpStatus.OK);
    }

}

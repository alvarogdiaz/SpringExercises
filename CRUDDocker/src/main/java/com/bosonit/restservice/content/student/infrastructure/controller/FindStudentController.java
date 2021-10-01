package com.bosonit.restservice.content.student.infrastructure.controller;

import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.infrastructure.controller.dto.output.SimpleStudentOutputDTO;
import com.bosonit.restservice.content.student.infrastructure.controller.dto.output.StudentOutputDTO;
import com.bosonit.restservice.content.student.infrastructure.repository.port.FindStudentPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/student")
public class FindStudentController {

    @Autowired
    private FindStudentPort findStudentPort;

    @GetMapping("{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<SimpleStudentOutputDTO> findById(
            @PathVariable int id,
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(getDTO(outputType, findStudentPort.findById(id)),
                HttpStatus.OK);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<SimpleStudentOutputDTO>> findAll(
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(findStudentPort.findAll().stream()
                .map(s -> getDTO(outputType, s))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("branch/{branch}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<SimpleStudentOutputDTO>> findByBranch(
            @PathVariable String branch,
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        findStudentPort.findByBranch(branch);
        return new ResponseEntity<>(findStudentPort.findByBranch(branch).stream()
                .map(s -> getDTO(outputType, s))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("teacher/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<SimpleStudentOutputDTO>> findByTeacherId(
            @PathVariable int id,
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(findStudentPort.findByTeacherId(id).stream()
                .map(s -> getDTO(outputType, s))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("subject/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<SimpleStudentOutputDTO>> findSubjects(
            @PathVariable int id,
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(findStudentPort.findBySubjectId(id).stream()
                .map(s -> getDTO(outputType, s))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    private SimpleStudentOutputDTO getDTO(String output, Student student) {
        return output.equals("simple") ? new SimpleStudentOutputDTO(student)
                : new StudentOutputDTO(student);
    }
}

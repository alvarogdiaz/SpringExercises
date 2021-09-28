package com.bosonit.restservice.content.subject.infrastructure.controller;

import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.output.SimpleSubjectOutputDTO;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.output.SubjectOutputDTO;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.FindSubjectPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/subject")
public class FindSubjectController {

    @Autowired
    private FindSubjectPort findSubjectPort;

    @GetMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<SimpleSubjectOutputDTO> findById(
            @PathVariable String id,
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(getDTO(outputType, findSubjectPort.findById(id)),
                HttpStatus.OK);
    }

    @GetMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<List<SimpleSubjectOutputDTO>> findAll(
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(findSubjectPort.findAll().stream()
                .map(s -> getDTO(outputType, s))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("subject/{subject}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<List<SimpleSubjectOutputDTO>> findByName(
            @PathVariable String subject,
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(findSubjectPort.findBySubject(subject).stream()
                .map(s -> getDTO(outputType, s))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("student/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<List<SimpleSubjectOutputDTO>> findByStudentId(
            @PathVariable String id,
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(findSubjectPort.findByStudentsId(id).stream()
                .map(s -> getDTO(outputType, s))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    private SimpleSubjectOutputDTO getDTO(String output, Subject subject) {
        return output.equals("simple") ? new SimpleSubjectOutputDTO(subject)
                : new SubjectOutputDTO(subject);
    }
}

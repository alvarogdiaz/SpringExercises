package com.bosonit.restservice.content.teacher.infrastructure.controller;

import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output.SimpleTeacherOutputDTO;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output.TeacherOutputDTO;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.FindTeacherPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/teacher")
public class FindTeacherController {

    @Autowired
    private FindTeacherPort findTeacherPort;

    @GetMapping("{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<SimpleTeacherOutputDTO> findById(
            @PathVariable int id,
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(getDTO(outputType, findTeacherPort.findById(id)),
                HttpStatus.OK);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<SimpleTeacherOutputDTO>> findAll(
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(findTeacherPort.findAll().stream()
                .map(s -> getDTO(outputType, s))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("branch/{branch}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<SimpleTeacherOutputDTO>> findByBranch(
            @PathVariable String branch,
            @RequestParam(defaultValue = "simple", required = false) String outputType)
            throws Exception {
        return new ResponseEntity<>(findTeacherPort.findByBranch(branch).stream()
                .map(s -> getDTO(outputType, s))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    private SimpleTeacherOutputDTO getDTO(String output, Teacher teacher) {
        return output.equals("simple") ? new SimpleTeacherOutputDTO(teacher)
                : new TeacherOutputDTO(teacher);
    }
}

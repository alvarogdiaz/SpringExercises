package com.bosonit.restservice.content.persona.infrastructure.controller;

import com.bosonit.restservice.content.persona.application.port.CreateStudentPort;
import com.bosonit.restservice.content.persona.domain.Student;
import com.bosonit.restservice.content.persona.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("api/student")
public class CreateStudentController {

    @Autowired
    private CreateStudentPort createStudentPort;

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> create(
            @Valid @RequestBody StudentInputDTO studentInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SaveStudent saveStudent = studentInputDTO.student(new SaveStudent());
        Student createStudent = createStudentPort.create(saveStudent, studentInputDTO.getId_persona());
        return new ResponseEntity<>(new StudentOutputDTO(createStudent), HttpStatus.CREATED);
    }
}

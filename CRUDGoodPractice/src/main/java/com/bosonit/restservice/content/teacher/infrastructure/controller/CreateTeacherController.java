package com.bosonit.restservice.content.teacher.infrastructure.controller;

import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.teacher.application.port.CreateTeacherPort;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.noDatabase.SaveTeacher;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.input.TeacherInputDTO;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.input.SimpleTeacherInputDTO;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output.TeacherOutputDTO;
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
@RequestMapping("api/teacher")
public class CreateTeacherController {

    @Autowired
    private CreateTeacherPort createTeacherPort;

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> create(
            @Valid @RequestBody SimpleTeacherInputDTO profesorInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SaveTeacher saveTeacher = profesorInputDTO.profesor(new SaveTeacher());
        Teacher createTeacher = createTeacherPort.create(saveTeacher, profesorInputDTO.getId_persona());
        return new ResponseEntity<>(new TeacherOutputDTO(createTeacher), HttpStatus.CREATED);
    }

    @PostMapping("add")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> create(
            @Valid @RequestBody TeacherInputDTO profesorInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SaveTeacher saveTeacher = profesorInputDTO.profesor(new SaveTeacher());
        SavePerson savePerson = profesorInputDTO.getId_persona().persona(new SavePerson());
        Teacher createTeacher = createTeacherPort.create(saveTeacher, savePerson);
        return new ResponseEntity<>(new TeacherOutputDTO(createTeacher), HttpStatus.CREATED);
    }
}

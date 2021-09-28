package com.bosonit.restservice.content.teacher.infrastructure.controller;

import com.bosonit.restservice.content.teacher.application.port.UpdateTeacherPort;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.noDatabase.SaveTeacher;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.input.SimpleTeacherInputDTO;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output.TeacherOutputDTO;
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
@RequestMapping("api/teacher")
public class UpdateTeacherController {

    @Autowired
    private UpdateTeacherPort updateTeacherPort;

    @PutMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> update(
            @PathVariable String id,
            @Valid @RequestBody SimpleTeacherInputDTO profesorInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SaveTeacher saveTeacher = profesorInputDTO.profesor(new SaveTeacher());
        Teacher updateTeacher;

        try {
            updateTeacher = updateTeacherPort.update(id, profesorInputDTO.getId_persona(), saveTeacher);
        } catch (Exception e) {
            throw new NotFoundException("Teacher with id " + id + " not found");
        }

        return new ResponseEntity<>(new TeacherOutputDTO(updateTeacher), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<TeacherOutputDTO> update(
            @PathVariable String id,
            @RequestParam(required = false) Integer id_persona,
            @RequestParam(required = false) String comments,
            @RequestParam(required = false) String branch)
            throws Exception {
        if (id_persona == null && branch == null && comments == null) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "All the data can't be NULL");
        }

        SaveTeacher saveTeacher = new SaveTeacher(comments, branch);
        Teacher updateTeacher;

        try {
            updateTeacher = updateTeacherPort.update(id, id_persona, saveTeacher);
        } catch (Exception e) {
            throw new NotFoundException("Teacher with id " + id + " not found");
        }

        return new ResponseEntity<>(new TeacherOutputDTO(updateTeacher), HttpStatus.OK);
    }
}

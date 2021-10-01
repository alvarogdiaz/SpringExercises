package com.bosonit.restservice.content.subject.infrastructure.controller;

import com.bosonit.restservice.content.subject.application.port.CreateSubjectPort;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.input.SimpleSubjectInputDTO;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.output.SubjectOutputDTO;
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
@RequestMapping("api/subject")
public class CreateSubjectController {

    @Autowired
    private CreateSubjectPort createSubjectPort;

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> create(
            @Valid @RequestBody SimpleSubjectInputDTO subjectInputDTO,
            Errors errors)
            throws Exception {
        if (errors.hasErrors()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    errors.getFieldError().getDefaultMessage());
        }

        SaveSubject saveSubject = subjectInputDTO.subject(new SaveSubject());
        Subject createSubject = createSubjectPort.create(saveSubject);
        return new ResponseEntity<>(new SubjectOutputDTO(createSubject), HttpStatus.CREATED);
    }
}

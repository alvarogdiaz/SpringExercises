package com.bosonit.restservice.content.student.application;

import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.SavePersonaPort;
import com.bosonit.restservice.content.student.application.port.CreateStudentPort;
import com.bosonit.restservice.content.persona.domain.PersonaJpa;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.FindPersonaPort;
import com.bosonit.restservice.content.student.infrastructure.repository.port.SaveStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateStudentUseCase implements CreateStudentPort {

    private SaveStudentPort saveStudentPort;
    private FindPersonaPort findPersonaPort;
    private SavePersonaPort savePersonaPort;

    @Override
    public Student create(SaveStudent saveStudent, int id) throws Exception {
        Student student = new Student();
        student.setId_persona(new PersonaJpa(findPersonaPort.findById(id)));
        student.update(saveStudent);
        return saveStudentPort.save(student);
    }

    @Override
    public Student create(SaveStudent saveStudent, SavePersona savePersona) throws Exception {
        Persona persona = new Persona();
        persona.update(savePersona);
        persona = savePersonaPort.save(persona);
        System.out.println(persona.getId_persona());

        Student student = new Student();
        student.setId_persona(new PersonaJpa(persona));
        student.update(saveStudent);
        return saveStudentPort.save(student);
    }
}

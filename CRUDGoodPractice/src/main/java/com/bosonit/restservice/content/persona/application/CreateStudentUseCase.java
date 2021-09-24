package com.bosonit.restservice.content.persona.application;

import com.bosonit.restservice.content.persona.application.port.CreateStudentPort;
import com.bosonit.restservice.content.persona.domain.PersonaJpa;
import com.bosonit.restservice.content.persona.domain.Student;
import com.bosonit.restservice.content.persona.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.FindPersonaPort;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.SaveStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateStudentUseCase implements CreateStudentPort {

    private SaveStudentPort saveStudentPort;
    private FindPersonaPort findPersonaPort;

    @Override
    public Student create(SaveStudent saveStudent, int id) throws Exception {
        Student student = new Student();
        student.setId_persona(new PersonaJpa(findPersonaPort.findById(id)));
        student.update(saveStudent);
        return saveStudentPort.save(student);
    }
}

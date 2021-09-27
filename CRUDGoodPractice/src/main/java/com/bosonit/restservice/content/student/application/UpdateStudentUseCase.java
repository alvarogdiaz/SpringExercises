package com.bosonit.restservice.content.student.application;

import com.bosonit.restservice.content.student.application.port.UpdateStudentPort;
import com.bosonit.restservice.content.persona.domain.PersonaJpa;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.persona.infrastructure.repository.port.FindPersonaPort;
import com.bosonit.restservice.content.student.infrastructure.repository.port.FindStudentPort;
import com.bosonit.restservice.content.student.infrastructure.repository.port.SaveStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateStudentUseCase implements UpdateStudentPort {

    private SaveStudentPort saveStudentPort;
    private FindStudentPort findStudentPort;
    private FindPersonaPort findPersonaPort;

    @Override
    public Student update(String id_student, SaveStudent saveStudent) throws Exception {
        Student student = findStudentPort.findById(id_student);
        student.update(saveStudent);
        return saveStudentPort.save(student);
    }

    @Override
    public Student update(String id_student, int id_person, SaveStudent saveStudent) throws Exception {
        Student student = findStudentPort.findById(id_student);
        student.setId_persona(new PersonaJpa(findPersonaPort.findById(id_person)));
        student.update(saveStudent);
        return saveStudentPort.save(student);
    }
}

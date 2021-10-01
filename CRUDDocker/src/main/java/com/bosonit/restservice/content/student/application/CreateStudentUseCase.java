package com.bosonit.restservice.content.student.application;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.person.infrastructure.repository.port.SavePersonPort;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.FindTeacherPort;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.SaveTeacherPort;
import com.bosonit.restservice.content.student.application.port.CreateStudentPort;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import com.bosonit.restservice.content.student.infrastructure.repository.port.SaveStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@AllArgsConstructor
public class CreateStudentUseCase implements CreateStudentPort {

    private SaveStudentPort saveStudentPort;
    private FindPersonPort findPersonPort;
    private FindTeacherPort findTeacherPort;
    private SaveTeacherPort saveTeacherPort;
    private SavePersonPort savePersonPort;

    @Override
    public Student create(SaveStudent saveStudent, int id_person) throws Exception {
        Student student = new Student();
        Person p = findPersonPort.findById(id_person);

        if (p.getPersonJpa().getStudentJpa() == null &&
                p.getPersonJpa().getTeacherJpa() == null) {
            student.setId_persona(p);
        } else {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "The person " + id_person + " is already a teacher or a student");
        }

        student.update(saveStudent);
        return saveStudentPort.save(student);
    }

    @Override
    public Student create(SaveStudent saveStudent, SavePerson savePersona) throws Exception {
        Person person = new Person();
        person.update(savePersona);
        person = savePersonPort.save(person);

        Student student = new Student();
        student.setId_persona(person);
        student.update(saveStudent);
        return saveStudentPort.save(student);
    }
}

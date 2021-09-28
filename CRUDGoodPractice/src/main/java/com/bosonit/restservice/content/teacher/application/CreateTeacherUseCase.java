package com.bosonit.restservice.content.teacher.application;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import com.bosonit.restservice.content.person.infrastructure.repository.port.SavePersonPort;
import com.bosonit.restservice.content.teacher.application.port.CreateTeacherPort;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.noDatabase.SaveTeacher;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.SaveTeacherPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@AllArgsConstructor
public class CreateTeacherUseCase implements CreateTeacherPort {

    private SaveTeacherPort saveTeacherPort;
    private FindPersonPort findPersonaPort;
    private SavePersonPort savePersonPort;

    @Override
    public Teacher create(SaveTeacher saveTeacher, int id) throws Exception {
        Teacher teacher = new Teacher();
        Person p = findPersonaPort.findById(id);

        if (p.getPersonJpa().getStudentJpa() == null &&
                p.getPersonJpa().getTeacherJpa() == null) {
            teacher.setId_persona(p);
        } else {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "The person " + id + " is already a teacher or a student");
        }

        teacher.update(saveTeacher);
        return saveTeacherPort.save(teacher);
    }

    @Override
    public Teacher create(SaveTeacher saveTeacher, SavePerson savePerson) throws Exception {
        Person person = new Person();
        person.update(savePerson);
        person = savePersonPort.save(person);

        Teacher teacher = new Teacher();
        teacher.setId_persona(person);
        teacher.update(saveTeacher);
        return saveTeacherPort.save(teacher);
    }
}

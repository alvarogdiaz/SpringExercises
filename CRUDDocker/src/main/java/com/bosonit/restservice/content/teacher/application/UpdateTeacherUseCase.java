package com.bosonit.restservice.content.teacher.application;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.infrastructure.repository.port.FindStudentPort;
import com.bosonit.restservice.content.teacher.application.port.UpdateTeacherPort;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.domain.noDatabase.SaveTeacher;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.FindTeacherPort;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.SaveTeacherPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@AllArgsConstructor
public class UpdateTeacherUseCase implements UpdateTeacherPort {

    private SaveTeacherPort saveTeacherPort;
    private FindTeacherPort findTeacherPort;
    private FindPersonPort findPersonPort;
    private FindStudentPort findStudentPort;

    @Override
    public Teacher update(int id_profesor, Integer id_person, SaveTeacher saveTeacher) throws Exception {
        Teacher teacher = findTeacherPort.findById(id_profesor);

        if (id_person != null) {
            Person p = findPersonPort.findById(id_person);
            if (p.getPersonJpa().getStudentJpa() == null &&
                    p.getPersonJpa().getTeacherJpa() == null) {
                teacher.setId_persona(p);
            } else {
                throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                        "The person " + id_person + " is already a teacher or a student");
            }
        }

        teacher.update(saveTeacher);
        return saveTeacherPort.save(teacher);
    }
}

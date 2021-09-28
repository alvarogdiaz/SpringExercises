package com.bosonit.restservice.content.student.application;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import com.bosonit.restservice.content.subject.infrastructure.controller.dto.input.SimpleSubjectInputDTO;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.FindSubjectPort;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.SaveSubjectPort;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.FindTeacherPort;
import com.bosonit.restservice.content.student.application.port.UpdateStudentPort;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import com.bosonit.restservice.content.student.infrastructure.repository.port.FindStudentPort;
import com.bosonit.restservice.content.student.infrastructure.repository.port.SaveStudentPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@AllArgsConstructor
public class UpdateStudentUseCase implements UpdateStudentPort {

    private SaveStudentPort saveStudentPort;
    private FindStudentPort findStudentPort;
    private FindTeacherPort findTeacherPort;
    private FindSubjectPort findSubjectPort;
    private FindPersonPort findPersonPort;
    private SaveSubjectPort saveSubjectPort;

    @Override
    public Student update(String id_student, Integer id_person, String id_profesor, SaveStudent saveStudent)
            throws Exception {

        Student student = findStudentPort.findById(id_student);

        if (id_person != null) {
            Person p = findPersonPort.findById(id_person);
            if (p.getPersonJpa().getStudentJpa() == null &&
                    p.getPersonJpa().getTeacherJpa() == null) {
                student.setId_persona(p);
            } else {
                throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                        "The person " + id_person + " is already a teacher or a student");
            }
        }
        if (id_profesor != null)
            student.setTeacher(findTeacherPort.findById(id_profesor));

        student.update(saveStudent);
        return saveStudentPort.save(student);
    }

    @Override
    public Student addSubject(String id_student, SaveSubject saveSubject) throws Exception {
        Student student = findStudentPort.findById(id_student);

        Subject subject = new Subject();
        subject.update(saveSubject);
        subject = saveSubjectPort.save(subject);

        student.addSubject(subject);
        return saveStudentPort.save(student);
    }

    @Override
    public Student addSubject(String id_student, String id_subject) throws Exception {
        Student student = findStudentPort.findById(id_student);
        Subject subject = findSubjectPort.findById(id_subject);

        student.addSubject(subject);
        return saveStudentPort.save(student);
    }

    @Override
    public Student teacher(String id_student, String id_teacher) throws Exception {
        Student student = findStudentPort.findById(id_student);
        Teacher teacher = findTeacherPort.findById(id_teacher);

        student.setTeacher(teacher);
        return saveStudentPort.save(student);
    }
}

package com.bosonit.restservice.content.student.application;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.subject.domain.Subject;
import com.bosonit.restservice.content.subject.infrastructure.repository.port.FindSubjectPort;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.infrastructure.repository.port.FindTeacherPort;
import com.bosonit.restservice.content.student.application.port.UpdateStudentPort;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import com.bosonit.restservice.content.student.infrastructure.repository.port.FindStudentPort;
import com.bosonit.restservice.content.student.infrastructure.repository.port.SaveStudentPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UpdateStudentUseCase implements UpdateStudentPort {

    private SaveStudentPort saveStudentPort;
    private FindStudentPort findStudentPort;
    private FindTeacherPort findTeacherPort;
    private FindSubjectPort findSubjectPort;
    private FindPersonPort findPersonPort;

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
    public Student addSubject(String id_student, String id_subject) throws Exception {
        Student student = findStudentPort.findById(id_student);
        Subject subject = findSubjectPort.findById(id_subject);

        Set<Subject> sub = new HashSet<>();

        if (student.getSubjects() != null)
            sub.addAll(student.getSubjects());

        sub.add(subject);
        student.setSubjects(sub);

        return saveStudentPort.save(student);
    }

    @Override
    public Student addSubjects(String id_student, String[] id_subject) throws Exception {
        Student student = findStudentPort.findById(id_student);

        Set<Subject> subjects = student.getSubjects();
        if (subjects == null) {
            subjects = new HashSet<>();
        }

        for (String s : id_subject) {
            subjects.add(findSubjectPort.findById(s));
        }

        student.setSubjects(subjects);

        return saveStudentPort.save(student);
    }

    @Override
    public Student unsubscribeSubject(String id_student, String id_subject) throws Exception {
        Student student = findStudentPort.findById(id_student);
        Subject subject = findSubjectPort.findById(id_subject);

        Set<Subject> sub = new HashSet<>();

        if (student.getSubjects() == null || student.getSubjects().size() == 0) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "The student " + id_student + " isn't subscribed to any subject");
        }

        sub.addAll(student.getSubjects());

        if (!sub.contains(subject)) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "The student " + id_student + " isn't subscribed to the subject " + id_subject);
        }

        sub.remove(subject);
        student.setSubjects(sub);

        return saveStudentPort.save(student);
    }

    @Override
    public Student unsubscribeSubjects(String id_student, String[] id_subject) throws Exception {
        Student student = findStudentPort.findById(id_student);

        Set<Subject> subjects = new HashSet<>();

        if (student.getSubjects() == null || student.getSubjects().size() == 0) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "The student " + id_student + " isn't subscribed to any subject");
        }

        subjects.addAll(student.getSubjects());

        Set<Subject> remove = new HashSet<>();

        for (String s : id_subject) {
            remove.add(findSubjectPort.findById(s));
        }

        int size = subjects.size();
        remove.stream().forEach(s -> {
            if (subjects.contains(s)) {
                subjects.remove(s);
            }
        });

        if (size == subjects.size()) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "The student " + id_student + " isn't subscribed to any of the subjects specified: "
                            + id_student.toString());
        }

        student.setSubjects(subjects);

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

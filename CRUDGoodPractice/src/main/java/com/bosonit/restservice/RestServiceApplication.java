package com.bosonit.restservice;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.infrastructure.repository.SavePersonRepository;
import com.bosonit.restservice.content.student.domain.Student;
import com.bosonit.restservice.content.student.infrastructure.repository.FindStudentRepository;
import com.bosonit.restservice.content.student.infrastructure.repository.SaveStudentRepository;
import com.bosonit.restservice.content.teacher.domain.Teacher;
import com.bosonit.restservice.content.teacher.infrastructure.repository.SaveTeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner add(SavePersonRepository savePersonRepository,
								 SaveStudentRepository saveStudentRepository,
								 SaveTeacherRepository saveTeacherRepository,
								 FindStudentRepository findStudentRepository) {
		return args -> {
			Person p1 = new Person();
			p1.setActive(true);
			p1.setCity("Zgz");
			p1.setCompany_email("a@gmail.com");
			p1.setPersonal_email("b@gmail.com");
			p1.setName("Manolo");
			p1.setSurname("Gomez");
			p1.setUser("usuario");
			p1.setPassword("pass");

			Person p2 = new Person();
			p2.setActive(true);
			p2.setCity("Zgz");
			p2.setCompany_email("a@gmail.com");
			p2.setPersonal_email("b@gmail.com");
			p2.setName("Manolo");
			p2.setSurname("Gomez");
			p2.setUser("usuario");
			p2.setPassword("pass");

			p1 = savePersonRepository.save(p1);
			p2 = savePersonRepository.save(p2);

			Teacher teacher = new Teacher();
			teacher.setBranch("FULLSTACK");
			teacher.setComments("");
			teacher.setId_persona(p1);

			Student student = new Student();
			student.setBranch("Backend");
			student.setComments("");
			student.setNum_hours_week(31);
			student.setId_persona(p2);

			/*student = saveStudentRepository.save(student);
			findStudentRepository.findByBranch("Backend");

			teacher = saveTeacherRepository.save(teacher);

			student.setTeacher(teacher);
			student = saveStudentRepository.save(student);

			findStudentRepository.findByBranch("Backend");*/

			//teacher.addStudent(student);
			//teacher = saveTeacherRepository.save(teacher);
		};
	}
}

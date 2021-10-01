package com.bosonit.restservice.content.person.domain;

import com.bosonit.restservice.content.teacher.domain.TeacherJpa;
import com.bosonit.restservice.content.student.domain.StudentJpa;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONA")
public class PersonJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_persona;

    @Column(nullable = false, length = 10)
    @Length(min = 6, max = 10, message = "Length of user out of range [6-10]")
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String name;

    @Column
    String surname;

    @Column(nullable = false)
    @Email(message = "Invalid company email")
    String company_email;

    @Column(nullable = false)
    @Email(message = "Invalid personal email")
    String personal_email;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    Boolean active;

    @Column(nullable = false)
    Date created_date;

    @Column
    String image_url;

    @Column
    Date termination_date;

    @OneToOne(mappedBy = "id_persona", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    TeacherJpa teacherJpa;

    @OneToOne(mappedBy = "id_persona", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    StudentJpa studentJpa;

    public PersonJpa(Person person) {
        this.id_persona = person.getId_persona();
        this.username = person.getUser();
        this.password = person.getPassword();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.city = person.getCity();
        this.company_email = person.getCompany_email();
        this.personal_email = person.getPersonal_email();
        this.image_url = person.getImage_url();
        this.active = person.getActive();
        this.created_date = person.getCreated_date();
        this.termination_date = person.getTermination_date();
    }
}

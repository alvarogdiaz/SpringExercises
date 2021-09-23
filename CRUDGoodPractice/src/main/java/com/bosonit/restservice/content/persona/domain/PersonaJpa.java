package com.bosonit.restservice.content.persona.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONA")
public class PersonaJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, length = 10)
    @Length(min = 6, max = 10, message = "Length of user out of range [6-10]")
    String user;

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

    public PersonaJpa(Persona persona) {
        this.id = persona.getId();
        this.user = persona.getUser();
        this.password = persona.getPassword();
        this.name = persona.getName();
        this.surname = persona.getSurname();
        this.city = persona.getCity();
        this.company_email = persona.getCompany_email();
        this.personal_email = persona.getPersonal_email();
        this.image_url = persona.getImage_url();
        this.active = persona.getActive();
        this.created_date = persona.getCreated_date();
        this.termination_date = persona.getTermination_date();
    }
}

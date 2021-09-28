package com.bosonit.restservice.content.person.domain;

import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import com.bosonit.restservice.content.person.infrastructure.controller.dto.input.PersonInputDTO;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private int id_persona;

    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date = new Date();
    private String image_url;
    private Date termination_date;

    private PersonJpa personJpa;

    public Person(PersonJpa personJpa) {
        if (personJpa == null) return;

        this.personJpa = personJpa;
        this.id_persona = personJpa.getId_persona();
        this.user = personJpa.getUser();
        this.name = personJpa.getName();
        this.password = personJpa.getPassword();
        this.city = personJpa.getCity();
        this.company_email = personJpa.getCompany_email();
        this.personal_email = personJpa.getPersonal_email();
        this.active = personJpa.getActive();
        this.surname = personJpa.getSurname();
        this.image_url = personJpa.getImage_url();
        this.created_date = personJpa.getCreated_date();
        this.termination_date = personJpa.getTermination_date();
    }

    public Person(PersonInputDTO personInputDTO) {
        this.user = personInputDTO.getUser();
        this.password = personInputDTO.getPassword();
        this.city = personInputDTO.getCity();
        this.name = personInputDTO.getName();
        this.surname = personInputDTO.getSurname();
        this.company_email = personInputDTO.getCompany_email();
        this.personal_email = personInputDTO.getPersonal_email();
        this.image_url = personInputDTO.getImage_url();
        this.active = personInputDTO.getActive();
    }

    public void update(SavePerson savePersona) {
        if (savePersona.getUser() != null)
            this.user = savePersona.getUser();
        if (savePersona.getPassword() != null)
            this.password = savePersona.getPassword();
        if (savePersona.getCity() != null)
            this.city = savePersona.getCity();
        if (savePersona.getCreated_date() != null)
            this.created_date = savePersona.getCreated_date();
        if (savePersona.getActive() != null)
            this.active = savePersona.getActive();
        if (savePersona.getName() != null)
            this.name = savePersona.getName();
        if (savePersona.getCompany_email() != null)
            this.company_email = savePersona.getCompany_email();
        if (savePersona.getPersonal_email() != null)
            this.personal_email = savePersona.getPersonal_email();
        if (savePersona.getSurname() != null)
            this.surname = savePersona.getSurname();
        if (savePersona.getImage_url() != null)
            this.image_url = savePersona.getImage_url();
        if (savePersona.getTermination_date() != null)
            this.termination_date = savePersona.getTermination_date();
    }
}

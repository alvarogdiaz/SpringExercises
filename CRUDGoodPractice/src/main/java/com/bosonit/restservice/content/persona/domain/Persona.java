package com.bosonit.restservice.content.persona.domain;

import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    private int id;

    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;

    private PersonaJpa personaJpa;

    public Persona(PersonaJpa personaJpa) {
        if (personaJpa == null) return;

        this.personaJpa = personaJpa;
        this.id = personaJpa.getId();
        this.user = personaJpa.getUser();
        this.name = personaJpa.getName();
        this.password = personaJpa.getPassword();
        this.city = personaJpa.getCity();
        this.company_email = personaJpa.getCompany_email();
        this.personal_email = personaJpa.getPersonal_email();
        this.active = personaJpa.getActive();
        this.surname = personaJpa.getSurname();
        this.image_url = personaJpa.getImage_url();
        this.created_date = personaJpa.getCreated_date();
        this.termination_date = personaJpa.getTermination_date();
    }

    public Persona(PersonaInputDTO personaInputDTO) {
        this.user = personaInputDTO.getUser();
        this.password = personaInputDTO.getPassword();
        this.city = personaInputDTO.getCity();
        this.name = personaInputDTO.getName();
        this.surname = personaInputDTO.getSurname();
        this.company_email = personaInputDTO.getCompany_email();
        this.personal_email = personaInputDTO.getPersonal_email();
        this.image_url = personaInputDTO.getImage_url();
        this.active = personaInputDTO.getActive();
        this.created_date = new Date();
    }

    public void update(SavePersona savePersona) {
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

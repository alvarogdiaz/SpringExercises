package com.bosonit.restservice.content.person.infrastructure.controller.dto.output;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.PersonJpa;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PersonOutputDTO implements Serializable {
    protected Integer id_persona;
    protected String name;
    protected String user;
    protected String image_url;
    protected Boolean active;

    public PersonOutputDTO(Person person) {
        this.setId_persona(person.getId_persona());
        this.setName(person.getName());
        this.setUser(person.getUser());
        this.setImage_url(person.getImage_url());
        this.setActive(person.getActive());
    }

    public PersonOutputDTO(PersonJpa personJpa) {
        this.setId_persona(personJpa.getId_persona());
        this.setName(personJpa.getName());
        this.setUser(personJpa.getUsername());
        this.setImage_url(personJpa.getImage_url());
        this.setActive(personJpa.getActive());
    }

}

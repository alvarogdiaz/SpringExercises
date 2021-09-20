package com.bosonit.restservice.content.persona.infrastructure.controller.dto.output;

import com.bosonit.restservice.content.persona.domain.Persona;
import com.bosonit.restservice.content.persona.domain.PersonaJpa;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class PersonaOutputDTO implements Serializable {
    protected int id;
    protected String name;
    protected String user;
    protected String image_url;
    protected Boolean active;

    public PersonaOutputDTO(Persona persona) {
        this.setId(persona.getId());
        this.setName(persona.getName());
        this.setUser(persona.getUser());
        this.setImage_url(persona.getImage_url());
        this.setActive(persona.getActive());
    }

    public PersonaOutputDTO(PersonaJpa personaJpa) {
        this.setId(personaJpa.getId());
        this.setName(personaJpa.getName());
        this.setUser(personaJpa.getUser());
        this.setImage_url(personaJpa.getImage_url());
        this.setActive(personaJpa.getActive());
    }

}

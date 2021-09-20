package com.bosonit.restservice.content.persona.infrastructure.controller.dto.input;

import com.bosonit.restservice.content.persona.domain.noDatabase.SavePersona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDTO {

    private String user;
    private String password;
    private String name;
    private String surname;
    private String city;
    private String company_email;
    private String personal_email;
    private String image_url;
    private Boolean active;

    public SavePersona persona(SavePersona savePersona) {
        savePersona.setUser(this.user);
        savePersona.setPassword(this.password);
        savePersona.setName(this.name);
        savePersona.setSurname(this.surname);
        savePersona.setCity(this.city);
        savePersona.setCompany_email(this.company_email);
        savePersona.setPersonal_email(this.personal_email);
        savePersona.setImage_url(this.image_url);
        savePersona.setActive(this.active);
        savePersona.setCreated_date(new Date());

        return savePersona;
    }
}

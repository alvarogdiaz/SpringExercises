package com.bosonit.restservice.content.persona.domain.noDatabase;

import com.bosonit.restservice.content.persona.domain.Persona;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SavePersona extends Persona {
    private String user;
    private String password;
    private String name;
    private String surname;
    private String city;
    private String company_email;
    private String personal_email;
    private String image_url;
    private Boolean active;
    private Date created_date;
    private Date termination_date;

    public SavePersona(Persona persona) {
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

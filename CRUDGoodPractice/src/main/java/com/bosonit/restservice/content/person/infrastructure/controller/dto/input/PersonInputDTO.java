package com.bosonit.restservice.content.person.infrastructure.controller.dto.input;

import com.bosonit.restservice.content.person.domain.noDatabase.SavePerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInputDTO implements Serializable {

    private String password;
    private String name;
    private String surname;
    private String city;
    private String image_url;
    private Boolean active;
    private Date termination_date;

    @Length(min = 6, max = 10, message = "Length of user out of range [6-10]")
    private String user;
    @Email(message = "Invalid company email")
    private String company_email;
    @Email(message = "Invalid personal email")
    private String personal_email;

    public SavePerson persona(SavePerson savePersona) {
        savePersona.setUser(this.user);
        savePersona.setPassword(this.password);
        savePersona.setName(this.name);
        savePersona.setSurname(this.surname);
        savePersona.setCity(this.city);
        savePersona.setCompany_email(this.company_email);
        savePersona.setPersonal_email(this.personal_email);
        savePersona.setImage_url(this.image_url);
        savePersona.setActive(this.active);
        savePersona.setTermination_date(this.termination_date);

        return savePersona;
    }
}

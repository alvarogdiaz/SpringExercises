package com.bosonit.restservice.content.person.domain.noDatabase;

import com.bosonit.restservice.content.person.domain.Person;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SavePerson extends Person {
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

    public SavePerson(Person person) {
        this.user = person.getUser();
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

package com.bosonit.restservice.entities;

import lombok.Data;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Data
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, length = 10)
    @Length(min = 6, max = 10, message = "Length out of range [6-10]")
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
    String imagen_url;

    @Column
    Date termination_date;

}

package com.bosonit.restservice.controllers;

import com.bosonit.restservice.interfaces.IPersonService;
import com.bosonit.restservice.entities.City;
import com.bosonit.restservice.impl.CityServiceImpl;
import com.bosonit.restservice.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("controlador2")
public class Controlador2 {

    @Autowired
    @Qualifier("person")
    Person p;

    @Autowired
    IPersonService personService;

    CityServiceImpl cityService;

    public Controlador2(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/getPersona", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson() {
        if (p.getName() == null) {
            System.out.println("NULL");
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }

        Person aux = new Person(p);
        aux.setAge(aux.getAge() * 2);
        return new ResponseEntity<Person>(aux, HttpStatus.OK);
    }

    @RequestMapping(value = "/getCiudad", method = RequestMethod.GET)
    public ResponseEntity<Collection<City>> getAllCities() {
        return new ResponseEntity<Collection<City>>(cityService.getCities(), HttpStatus.OK);
    }
}
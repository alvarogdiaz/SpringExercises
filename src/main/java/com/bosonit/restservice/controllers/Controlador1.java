package com.bosonit.restservice.controllers;

import com.bosonit.restservice.impl.CityServiceImpl;
import com.bosonit.restservice.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("controlador1")
public class Controlador1 {

    @Autowired
    @Qualifier("person")
    Person p;

    CityServiceImpl cityService;

    public Controlador1(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/addPersona", method = RequestMethod.GET)
    public ResponseEntity<Person> addPersona(@RequestHeader(name = "name") String name,
                                             @RequestHeader(name = "city") String city,
                                             @RequestHeader(name = "age") int age) {

        p = new Person(0, name, city, age);
        return new ResponseEntity<Person>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/addCiudad", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addCity(@RequestParam(name = "name") String name,
                                              @RequestParam(name = "population") int population) {

        if(!cityService.existsCity(name)) {
            cityService.addCity(name, population);
            return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }
}
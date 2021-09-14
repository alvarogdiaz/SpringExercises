package com.example.restservice.controllers;

import com.example.restservice.city.City;
import com.example.restservice.city.CityServiceImpl;
import com.example.restservice.person.Person;
import com.example.restservice.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RS1 {

    @Autowired
    PersonService personService;

    CityServiceImpl cityService;

    public RS1(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public ResponseEntity<City> json(@RequestBody City city) {
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        if(personService.existsPerson(id)) {
            return new ResponseEntity<Person>(personService.getPerson(id), HttpStatus.OK);
        }

        return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> getCity(@PathVariable String id) {
        if(cityService.exists(id)) {
            return new ResponseEntity<City>(cityService.getCity(id), HttpStatus.OK);
        }

        return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/addCiudad", method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> addCity(@RequestParam(name = "name") String name,
                                              @RequestParam(name = "population") int population) {

        if(!cityService.exists(name)) {
            cityService.addCity(name, population);
            return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }
}

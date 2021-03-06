package com.bosonit.restservice.controllers;

import com.bosonit.restservice.domain.City;
import com.bosonit.restservice.service.impl.CityServiceImpl;
import com.bosonit.restservice.domain.Person;
import com.bosonit.restservice.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RS1 {

    @Autowired
    IPersonService personService;

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
        if(cityService.existsCity(id)) {
            return new ResponseEntity<City>(cityService.getCity(id), HttpStatus.OK);
        }

        return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/addCiudad", method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> addCity(@RequestParam(name = "name") String name,
                                              @RequestParam(name = "population") int population) {

        if(!cityService.existsCity(name)) {
            cityService.addCity(name, population);
            return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }
}

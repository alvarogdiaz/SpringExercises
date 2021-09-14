package com.bosonit.restservice.controllers;

import com.bosonit.restservice.person.PersonService;
import com.bosonit.restservice.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addPerson(@RequestBody Person p) {
        personService.createPerson(p);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/nombre/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getPersonByName(@PathVariable String nombre) {
        return new ResponseEntity<List<Person>>(personService.getPersonByName(nombre), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        if(personService.existsPerson(id)) {
            return new ResponseEntity<Person>(personService.getPerson(id), HttpStatus.OK);
        }

        return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable(name = "id") int id) {
        if(personService.existsPerson(id)) {
            personService.deletePerson(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@PathVariable int id,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String city,
                                               @RequestParam(required = false) Integer age) {

        if(name == null && city == null && age == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(personService.existsPerson(id)) {
            return new ResponseEntity<Person>(
                    personService.updatePerson(id, name, city, age == null ? -1 : age),
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> allPerson() {
        return new ResponseEntity<Collection<Person>>(personService.getPeople(), HttpStatus.OK);
    }

}
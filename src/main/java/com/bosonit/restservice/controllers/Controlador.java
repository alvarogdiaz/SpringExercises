package com.bosonit.restservice.controllers;

import com.bosonit.restservice.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controlador")
public class Controlador {
    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "/bean/{bean}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable String bean) {
        if(bean.matches("bean[1-3]")) {
            return new ResponseEntity<Person>((Person) context.getBean(bean), HttpStatus.OK);
        }

        return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }
}

package com.bosonit.restservice.controllers;

import com.bosonit.restservice.entities.Persona;
import com.bosonit.restservice.repository.impl.PersonaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("personaJPA")
public class PersonJPAController {

    @Autowired
    PersonaRepositoryImpl personaRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> create() {
        if (personaRepository.save(personaRepository.defPerson("aaa", "a@gmail.com")))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "a", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> create2(@RequestParam String user, @RequestParam String email) {
        if (personaRepository.save(personaRepository.defPerson(user, email)))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Persona> findById(@PathVariable int id) {
        Optional<Persona> p = personaRepository.findById(id);

        if (p.isPresent()) {
            return new ResponseEntity<Persona>(p.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> findByName(@PathVariable String name) {
        return new ResponseEntity<List<Persona>>
                (personaRepository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> findAll() {
        return new ResponseEntity<List<Persona>>
                (personaRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {
        if (personaRepository.deleteById(id))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> delete() {
        if (personaRepository.deleteAll())
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteByPerson(@RequestBody Persona p) {
        if (personaRepository.delete(p))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> updateById(@PathVariable int id, @RequestParam(required = false) String user,
                                                 @RequestParam(required = false) String pass,
                                                 @RequestParam(required = false) String name,
                                                 @RequestParam(required = false) String surn,
                                                 @RequestParam(required = false) String comp,
                                                 @RequestParam(required = false) String pers,
                                                 @RequestParam(required = false) String city,
                                                 @RequestParam(required = false) Boolean acti,
                                                 @RequestParam(required = false) Date crea,
                                                 @RequestParam(required = false) String img,
                                                 @RequestParam(required = false) Date term) {
        if (user == null && name == null && pass == null && surn == null && pers == null && city == null &&
            comp == null && acti == null && crea == null && img == null && term == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (personaRepository.updateById(id, user, pass, name, surn, comp, pers, city, acti, crea, img, term))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> updateByPerson(@RequestBody Persona p) {
        if (personaRepository.delete(p))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

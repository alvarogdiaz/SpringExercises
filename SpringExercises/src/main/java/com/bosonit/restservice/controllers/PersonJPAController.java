package com.bosonit.restservice.controllers;

import com.bosonit.restservice.entities.Persona;
import com.bosonit.restservice.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("personaJPA")
public class PersonJPAController {

    @Autowired
    PersonaRepository personaRepository;

    private Boolean updatePerson(Persona p) {
        try {
            Optional<Persona> op = personaRepository.findById(p.getId());
            if (op.isEmpty()) throw new Exception("");

            p.setId(op.get().getId());
            personaRepository.save(p);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private Boolean updateId(int id, String user, String pass, String name, String surn, String cema,
                              String pema, String city, Boolean act, Date crea, String img, Date term) {
        try {
            Optional<Persona> op = personaRepository.findById(id);
            if (op.isEmpty()) throw new Exception("");

            Persona p = op.get();
            if (user != null) p.setUser(user);
            if (pass != null) p.setPassword(pass);
            if (name != null) p.setName(name);
            if (surn != null) p.setUser(surn);
            if (cema != null) p.setCompany_email(cema);
            if (pema != null) p.setPersonal_email(pema);
            if (city != null) p.setCity(city);
            if (img != null)  p.setImagen_url(img);
            if (act != null)  p.setActive(act);
            if (crea != null) p.setCreated_date(crea);
            if (term != null) p.setTermination_date(term);

            personaRepository.save(p);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody Persona p) {
        try {
            personaRepository.save(p);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
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
                (personaRepository.findAllByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> findAll() {
        return new ResponseEntity<List<Persona>>
                (personaRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {
        try {
            personaRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> delete() {
        try {
            personaRepository.deleteAll();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteByPerson(@Valid @RequestBody Persona p) {
        try {
            personaRepository.delete(p);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
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

        if (updateId(id, user, pass, name, surn, comp, pers, city, acti, crea, img, term))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> updateByPerson(@Valid @RequestBody Persona p) {
        if (updatePerson(p))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

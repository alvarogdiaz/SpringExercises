package com.bosonit.restservice.repository.impl;

import com.bosonit.restservice.entities.Persona;
import com.bosonit.restservice.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepositoryImpl {

    @Autowired
    PersonaRepository personaRepository;

    public Persona defPerson(String user, String email) {
        Persona p = new Persona();
        p.setCity("Barcelona");
        p.setName("Lolo");
        p.setActive(false);
        p.setPassword("qwerty");
        p.setUser(user);
        p.setCompany_email(email);
        p.setPersonal_email("b@outlook.com");
        p.setCreated_date(new Date());
        return p;
    }

    public Boolean save(Persona p) {
         try {
             personaRepository.save(p);
         } catch (Exception e) {
             return false;
         }

         return true;
    }

    public Optional<Persona> findById(int id) {
        return personaRepository.findById(id);
    }

    public List<Persona> findByName(String name) {
        return personaRepository.findAllByName(name);
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Boolean deleteById(int id) {
         try {
             personaRepository.deleteById(id);
         } catch (Exception e) {
             return false;
        }
         return true;
    }

    public Boolean delete(Persona p) {
         try {
             personaRepository.delete(p);
         } catch (Exception e) {
             return false;
         }
         return true;
    }

    public Boolean deleteAll() {
         try {
             personaRepository.deleteAllInBatch();
         } catch (Exception e) {
             return false;
         }
         return true;
    }

    public Boolean updateById(int id, String user, String pass, String name, String surn, String cema,
                              String pema, String city, Boolean act, Date crea, String img, Date term) {
         try {
             Optional<Persona> op = personaRepository.findById(id);
             if (!op.isPresent()) throw new Exception("");

             Persona p = op.get();
             if (user == null) user = p.getUser();
             if (pass == null) pass = p.getPassword();
             if (name == null) name = p.getName();
             if (surn == null) surn = p.getUser();
             if (cema == null) cema = p.getCompany_email();
             if (pema == null) pema = p.getPersonal_email();
             if (city == null) city = p.getCity();
             if (img == null) img = p.getImagen_url();
             if (act == null) act = p.getActive();
             if (crea == null) crea = p.getCreated_date();
             if (term == null) term = p.getTermination_date();

             //personaRepository.update(user, pass, name, city, cema, pema, crea, surn, img, term, act, id);
         } catch (Exception e) {
             return false;
         }

         return true;
    }

}

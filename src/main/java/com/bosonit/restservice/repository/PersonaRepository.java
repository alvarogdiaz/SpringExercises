package com.bosonit.restservice.repository;

import com.bosonit.restservice.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    List<Persona> findAllByName(String name);

    /*@Query("update Persona p set p.user = :user and p.password = :pass and p.name = :name and p.city = :city " +
            "and p.company_email = :cema and p.personal_email = :pema and p.created_date = :crea and p.surname = :surn " +
            "and p.imagen_url = :img and p.termination_date = :term and p.active = :act where p.id = :id")
    void update(@Param("user") String user, @Param("pass") String pass, @Param("name") String name,
                @Param("city") String city, @Param("cema") String cema, @Param("pema") String pema,
                @Param("crea") Date crea, @Param("surn") String surn, @Param("img") String img,
                @Param("term") Date term, @Param("act") Boolean act, @Param("id") int id);*/

}

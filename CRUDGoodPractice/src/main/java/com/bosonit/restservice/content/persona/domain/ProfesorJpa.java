package com.bosonit.restservice.content.persona.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROFESOR")
public class ProfesorJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_profesor;

    @JoinColumn(name = "persona")
    @OneToOne(fetch = FetchType.LAZY)
    private PersonaJpa id_persona;

    @Column
    private String comments;

    @Column(nullable = false)
    private String branch;

    @ManyToMany(mappedBy = "profesores")
    private Set<StudentJpa> students;

}

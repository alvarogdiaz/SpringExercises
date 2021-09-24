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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona")
    private PersonaJpa id_persona;

    @Column
    private String comments;

    @Column(nullable = false)
    private String branch;

    @OneToMany(mappedBy = "id_profesor", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<StudentJpa> students;

}

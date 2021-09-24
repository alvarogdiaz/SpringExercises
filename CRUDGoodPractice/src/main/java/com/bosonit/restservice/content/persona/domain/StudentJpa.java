package com.bosonit.restservice.content.persona.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
public class StudentJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_student;

    @JoinColumn(name = "persona")
    @OneToOne(fetch = FetchType.LAZY)
    private PersonaJpa id_persona;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "profesores",
            joinColumns = {@JoinColumn(name = "id_student")},
            inverseJoinColumns = {@JoinColumn(name = "id_profesor")})
    private Set<ProfesorJpa> profesores;

    @Column(nullable = false)
    private int num_hours_week;

    @Column
    private String comments;

    @Column(nullable = false)
    private String branch;

    @OneToMany(mappedBy = "id_asignatura", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AsignaturaJpa> asignaturas;

}

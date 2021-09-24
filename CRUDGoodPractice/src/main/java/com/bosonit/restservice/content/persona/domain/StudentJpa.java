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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona")
    private PersonaJpa id_persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private ProfesorJpa id_profesor;

    @Column(nullable = false)
    private Integer num_hours_week;

    @Column
    private String comments;

    @Column(nullable = false)
    private String branch;

    /*@OneToMany(mappedBy = "id_asignatura", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AsignaturaJpa> asignaturas;*/

    public StudentJpa(Student student) {
        this.id_student = student.getId_student();
        this.id_persona = student.getId_persona();
        //this.id_profesor = student.getId_profesor().getId_profesor();
        this.num_hours_week = student.getNum_hours_week();
        this.branch = student.getBranch();
        this.comments = student.getComments();
    }

}

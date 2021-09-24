package com.bosonit.restservice.content.persona.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASIGNATURA")
public class AsignaturaJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_asignatura;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    private StudentJpa id_student;*/

    @Column
    private String asignatura;

    @Column
    private String comments;

    @Column(nullable = false)
    private Date initial_date;

    @Column
    private Date finish_date;

}

package com.bosonit.restservice.content.subject.infrastructure.repository.jpa;

import com.bosonit.restservice.content.subject.domain.SubjectJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepositoryJpa extends JpaRepository<SubjectJpa, Integer> {

    List<SubjectJpa> findAllByAsignatura(String asignatura);
    List<SubjectJpa> findAllByStudentsId(Integer id);

}

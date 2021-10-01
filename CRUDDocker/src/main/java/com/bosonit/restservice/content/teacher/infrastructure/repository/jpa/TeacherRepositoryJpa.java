package com.bosonit.restservice.content.teacher.infrastructure.repository.jpa;

import com.bosonit.restservice.content.teacher.domain.TeacherJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepositoryJpa extends JpaRepository<TeacherJpa, Integer> {

    List<TeacherJpa> findAllByBranch(String branch);

}

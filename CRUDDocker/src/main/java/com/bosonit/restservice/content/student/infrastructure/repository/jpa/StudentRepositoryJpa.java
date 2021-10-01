package com.bosonit.restservice.content.student.infrastructure.repository.jpa;

import com.bosonit.restservice.content.student.domain.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositoryJpa extends JpaRepository<StudentJpa, Integer> {

    List<StudentJpa> findAllByBranch(String branch);
    List<StudentJpa> findAllByTeacherId(Integer id) throws Exception;
    List<StudentJpa> findAllBySubjectsId(Integer id) throws Exception;
}

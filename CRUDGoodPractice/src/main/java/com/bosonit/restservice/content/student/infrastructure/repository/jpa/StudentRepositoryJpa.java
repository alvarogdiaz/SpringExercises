package com.bosonit.restservice.content.student.infrastructure.repository.jpa;

import com.bosonit.restservice.content.student.domain.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositoryJpa extends JpaRepository<StudentJpa, String> {

    List<StudentJpa> findAllByBranch(String branch);
    //List<StudentJpa> findAllById_profesor(String id);

}

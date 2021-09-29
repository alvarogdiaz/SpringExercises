package com.bosonit.restservice.content.person.infrastructure.repository;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import com.bosonit.restservice.content.person.infrastructure.repository.port.DeletePersonPort;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

@Repository
@AllArgsConstructor
public class DeletePersonRepository implements DeletePersonPort {

    private PersonRepositoryJpa personRepositoryJpa;
    private FindPersonPort findPersonPort;

    @Override
    public void delete(int id) throws Exception {
        Person p = findPersonPort.findById(id);

        if (p.getPersonJpa().getStudentJpa() == null && p.getPersonJpa().getTeacherJpa() == null) {
            personRepositoryJpa.deleteById(id);
        } else {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Delete the student or teacher associated first");
        }
    }

    @Override
    public void delete() throws Exception {
        personRepositoryJpa.deleteAll();
    }
}

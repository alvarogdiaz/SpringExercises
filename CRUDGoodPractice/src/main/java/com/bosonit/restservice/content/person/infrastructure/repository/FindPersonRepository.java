package com.bosonit.restservice.content.person.infrastructure.repository;

import com.bosonit.restservice.content.person.domain.Person;
import com.bosonit.restservice.content.person.domain.PersonJpa;
import com.bosonit.restservice.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FindPersonRepository implements FindPersonPort {

    @PersistenceContext
    private EntityManager entityManager;

    private PersonRepositoryJpa personRepositoryJpa;

    @Override
    public List<Person> findAll(int num, int size) throws Exception {
        Pageable page = PageRequest.of(num, size);
        return personRepositoryJpa.findAll(page).stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    @Override
    public Person findById(int id) throws Exception {
        PersonJpa p = personRepositoryJpa.findById(id).orElseThrow(() ->
            new NotFoundException("Person with id " + id + " not found"));

        return new Person(p);
    }

    @Override
    public List<Person> findByName(String name, int num, int size) throws Exception {
        Pageable page = PageRequest.of(num, size);
        return personRepositoryJpa.findAllByName(name, page).stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findByUser(String user, int num, int size) throws Exception {
        Pageable page = PageRequest.of(num, size);
        return personRepositoryJpa.findAllByUser(user, page).stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getData(HashMap<String, Object> cond, int num, int size) throws Exception {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonJpa> query = cb.createQuery(PersonJpa.class);
        Root<PersonJpa> root = query.from(PersonJpa.class);

        List<Predicate> predicates = new ArrayList<>();
        cond.forEach((key, value) -> {
            switch (key) {
                case "id_persona":
                case "password":
                case "company_email":
                case "personal_email":
                case "city":
                case "active":
                case "image_url":
                case "termination_date":
                    predicates.add(cb.equal(root.get(key), value));
                    break;
                case "user":
                case "surname":
                case "created_date":
                case "name":
                    conditions(cond, predicates, cb, root, key, value);
                    break;
            }
        });

        List<Order> orderList = new ArrayList<>();
        String s = (String) cond.get("orderBy");
        if (s != null) {
            String order = (String) cond.get("order");
            if (order != null) {
                if (order.equals("asc")) {
                    orderList.add(cb.asc(root.get(s)));
                } else {
                    orderList.add(cb.desc(root.get(s)));
                }
            }
        }

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(orderList);
        TypedQuery<PersonJpa> typedQuery = entityManager.createQuery(query)
                .setFirstResult(num * size)
                .setMaxResults(size);

        return typedQuery.getResultList().stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    private void conditions(HashMap<String, Object> cond, List<Predicate> predicates,
                            CriteriaBuilder cb, Root<PersonJpa> root,
                            String key, Object value) {
        String s = (String) cond.get(key + "Cond");
        if (s != null) {
            switch (s) {
                case "greater":
                    if (key.equals("created_date"))
                        predicates.add(cb.greaterThan(root.<Date>get(key), (Date) value));
                    else
                        predicates.add(cb.greaterThan(root.<String>get(key), (String) value));
                    break;
                case "greaterorequal":
                    if (key.equals("created_date"))
                        predicates.add(cb.greaterThanOrEqualTo(root.<Date>get(key), (Date) value));
                    else
                        predicates.add(cb.greaterThanOrEqualTo(root.<String>get(key), (String) value));
                    break;
                case "less":
                    if (key.equals("created_date"))
                        predicates.add(cb.lessThan(root.<Date>get(key), (Date) value));
                    else
                        predicates.add(cb.lessThan(root.<String>get(key), (String) value));
                    break;
                case "lessorequal":
                    if (key.equals("created_date"))
                        predicates.add(cb.lessThanOrEqualTo(root.<Date>get(key), (Date) value));
                    else
                        predicates.add(cb.lessThanOrEqualTo(root.<String>get(key), (String) value));
                    break;
            }
        } else {
            predicates.add(cb.equal(root.get(key), value));
        }
    }
}

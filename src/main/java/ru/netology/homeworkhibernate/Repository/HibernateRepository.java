package ru.netology.homeworkhibernate.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.homeworkhibernate.entity.Persons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class HibernateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List getPersonsByCity(@RequestParam("city") String city) {

        return entityManager.createQuery("select p from Persons p where p.cityOfLiving = '" + city + "'", Persons.class).getResultList();
    }
}

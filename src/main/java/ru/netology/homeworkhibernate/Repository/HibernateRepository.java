package ru.netology.homeworkhibernate.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.homeworkhibernate.entity.Persons;

import java.util.*;

@Repository
public class HibernateRepository {

    @Autowired
    PersonRepository personRepository;

    @Query("select p from Persons p where p.cityOfLiving =:city")
    public List getPersonsByCity(@RequestParam("city") String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @Query("select p from Persons p where p.age <:age order by p.age asc")
    public List getPersonsByAge(@RequestParam("age") int age) {
        return  personRepository.findByAgeIsLessThanOrderByAgeAsc(age);
    }

    @Query("select p from Persons p where p.name =:name and p.surname =:surname")
    public Optional<Persons> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}

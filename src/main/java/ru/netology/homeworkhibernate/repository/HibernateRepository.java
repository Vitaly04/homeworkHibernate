package ru.netology.homeworkhibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Repository
public class HibernateRepository {

    @Autowired
    PersonRepository personRepository;

    public List getPersonsByCity(@RequestParam("city") String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List getPersonsByAge(@RequestParam("age") int age) {
        return  personRepository.findByAgeIsLessThanOrderByAgeAsc(age);
    }

    public List getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}

package ru.netology.homeworkhibernate.Service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.homeworkhibernate.Repository.HibernateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.homeworkhibernate.entity.Persons;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HibernateService {
    HibernateRepository hibernateRepository;

    public List getPersonsByCity(@RequestParam("city") String city) {

        return hibernateRepository.getPersonsByCity(city);
    }

    public List getPersonsByAge(@RequestParam("age") int age) {
        return hibernateRepository.getPersonsByAge(age);
    }

    public Optional<Persons> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return hibernateRepository.getPersonsByNameAndSurname(name, surname);
    }
}

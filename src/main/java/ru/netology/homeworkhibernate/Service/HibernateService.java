package ru.netology.homeworkhibernate.Service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.homeworkhibernate.Repository.HibernateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return hibernateRepository.getPersonsByNameAndSurname(name, surname);
    }
}

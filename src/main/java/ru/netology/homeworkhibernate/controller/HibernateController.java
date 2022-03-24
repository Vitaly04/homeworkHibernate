package ru.netology.homeworkhibernate.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.homeworkhibernate.Service.HibernateService;
import lombok.AllArgsConstructor;
import ru.netology.homeworkhibernate.entity.Persons;

import java.util.List;

@RestController
@AllArgsConstructor
public class HibernateController {
    HibernateService hibernateService;

    @GetMapping("/persons/city")
    public List getPersonsByCity(@RequestParam("city") String city) {
        return hibernateService.getPersonsByCity(city);
    }

    @GetMapping(value = "/persons/age", params = {"age"})
    public List getPersonsByAge(@RequestParam int age) {
        return hibernateService.getPersonsByAge(age);
    }

    @GetMapping(value = "/persons/name", params = {"name", "surname"})
    public List<Persons> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return hibernateService.getPersonsByNameAndSurname(name, surname);
    }
}

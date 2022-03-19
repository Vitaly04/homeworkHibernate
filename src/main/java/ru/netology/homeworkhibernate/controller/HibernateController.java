package ru.netology.homeworkhibernate.controller;

import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.homeworkhibernate.Service.HibernateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class HibernateController {
    HibernateService hibernateService;

    @GetMapping("/persons/by-city")
    public List getPersonsByCity(@RequestParam("city") String city) {
        return hibernateService.getPersonsByCity(city);
    }
}

package ru.netology.homeworkhibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.homeworkhibernate.entity.Persons;
import ru.netology.homeworkhibernate.service.HibernateService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@AllArgsConstructor
public class SecurityController {
    HibernateService hibernateService;

    @Secured({"ROLE_READ"})
    @GetMapping(value = "/persons/read", params = {"name", "surname"})
    public List getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return hibernateService.getPersonsByNameAndSurname(name, surname);
    }

    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping(value = "/persons/write", params = {"age"})
    public List getPersonsByAge(@RequestParam int age) {
        return hibernateService.getPersonsByAge(age);
    }

    @PreAuthorize("hasAnyRole('WRITE') or hasAnyRole('DELETE')")
    @GetMapping(value = "/persons/role", params = {"city"})
    public List getPersonsByCity(@RequestParam("city") String city) {
        return hibernateService.getPersonsByCity(city);
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping(value = "/persons/authories", params = {"username"})
    public String getName(@RequestParam String username) {
        return username;
    }
}

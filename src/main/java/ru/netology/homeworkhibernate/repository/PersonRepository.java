package ru.netology.homeworkhibernate.repository;

import org.springframework.data.repository.CrudRepository;
import ru.netology.homeworkhibernate.entity.Persons;
import ru.netology.homeworkhibernate.entity.PersonsPK;

import java.util.List;

public interface PersonRepository extends CrudRepository<Persons, PersonsPK> {

    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByAgeIsLessThanOrderByAgeAsc(Integer age);

    List<Persons> findByNameAndSurname(String name, String surname);
}

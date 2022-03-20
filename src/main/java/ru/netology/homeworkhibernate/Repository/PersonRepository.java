package ru.netology.homeworkhibernate.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.netology.homeworkhibernate.entity.Persons;
import ru.netology.homeworkhibernate.entity.PersonsPK;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Persons, PersonsPK> {

    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByAgeIsLessThanOrderByAgeAsc(Integer age);

    Optional<Persons> findByNameAndSurname(String name, String surname);
}

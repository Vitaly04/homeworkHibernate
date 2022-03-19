package ru.netology.homeworkhibernate.Repository;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.homeworkhibernate.entity.Persons;

import javax.persistence.EntityManager;
import java.util.Random;
import java.util.stream.IntStream;

@Component
@AllArgsConstructor
public class LoaderPersons implements ApplicationRunner {

    EntityManager entityManager;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        var names = java.util.List.of("alexey", "karl", "rex", "bob");
        var surnames = java.util.List.of("smith", "fox", "west", "ford");
        var phoneNumbers = java.util.List.of("1111", "2222", "3333", "4444");
        var cityOfLiving = java.util.List.of("Moscow", "Paris", "Tokyo", "Deli");
        var random = new Random();

        IntStream.range(0, 20)
                .forEach(i -> {
                    var persons = Persons.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(90))
                            .phoneNumber(phoneNumbers.get(random.nextInt(phoneNumbers.size())))
                            .cityOfLiving(cityOfLiving.get(random.nextInt(cityOfLiving.size())))
                            .build();
                    entityManager.persist(persons);
                });
    }
}

package ru.netology.homeworkhibernate.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Persons implements Serializable {

    @Id
    @Column(nullable = false)
    private String name;

    @Id
    private String surname;

    @Id
    private int age;

    private String phoneNumber;

    private String cityOfLiving;
}

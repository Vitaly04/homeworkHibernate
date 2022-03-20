package ru.netology.homeworkhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class PersonsPK implements Serializable {
    @Id
    @Column(nullable = false)
    private String name;

    @Id
    private String surname;

    @Id
    private int age;
}

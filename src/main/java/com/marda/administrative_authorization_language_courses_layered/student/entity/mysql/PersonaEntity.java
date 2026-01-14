package com.marda.administrative_authorization_language_courses_layered.student.entity.mysql;

import com.marda.administrative_authorization_language_courses_layered.commons.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class PersonaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "persona_id")
    private Long id;

    @Column(name = "persona_first_name")
    private String firstName;

    @Column(name = "persona_middle_name")
    private String middleName;

    @Column(name = "persona_first_surname")
    private String firstSurname;

    @Column(name = "persona_second_surname")
    private String secondSurname;

    @Column(name = "persona_birthdate")
    private LocalDate birthDate;
}

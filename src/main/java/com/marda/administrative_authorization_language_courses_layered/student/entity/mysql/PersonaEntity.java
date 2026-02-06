package com.marda.administrative_authorization_language_courses_layered.student.entity.mysql;

import com.marda.administrative_authorization_language_courses_layered.base.entity.BaseEntity;
import com.marda.administrative_authorization_language_courses_layered.commons.entity.constants.EntityConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Comment(value = "Table register personal data of people")
@Entity(name = "PersonaEntity")
@Table(name = EntityConstants.PERSONA)
public class PersonaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

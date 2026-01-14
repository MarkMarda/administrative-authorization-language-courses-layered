package com.marda.administrative_authorization_language_courses_layered.student.entity.mysql;

import com.marda.administrative_authorization_language_courses_layered.commons.entity.constants.EntityConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Comment(value = "Table register students data")
@Entity(name = "StudentEntity")
@Table(name = EntityConstants.STUDENT)
public class StudentEntity extends PersonaEntity {
    @Column(name = "student_id_credential")
    private Long idCredential;

    @Column(name = "student_enrolled_language_courses")
    private List<String> enrolledLanguageCourses;

    @Column(name = "student_phone_number")
    private String phoneNumber;

    @Column(name = "student_email")
    private String email;

//    @Column(name = "student_")
//    private Email email;
}

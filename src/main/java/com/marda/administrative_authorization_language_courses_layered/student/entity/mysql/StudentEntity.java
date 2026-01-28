package com.marda.administrative_authorization_language_courses_layered.student.entity.mysql;

import com.marda.administrative_authorization_language_courses_layered.commons.entity.constants.EntityConstants;
import com.marda.administrative_authorization_language_courses_layered.student.entity.vo.Email;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Comment(value = "Table register students data")
@Entity(name = "StudentEntity")
@Table(name = EntityConstants.STUDENT)
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", nullable = false)
    private PersonaEntity persona;

    @Column(name = "student_id_credential")
    private Long idCredential;

    //@Column(name = "student_enrolled_language_courses")
    @ElementCollection
    @CollectionTable(
            name = "student_language_courses",
            joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "languages")
    private List<String> enrolledLanguageCourses;

    @Column(name = "student_phone_number")
    private String phoneNumber;

    @Embedded
    //In case we have more VO (we need Embedded) this solving collisions
    @AttributeOverride(
            name = "value",
            column = @Column(name = "student_email")
    )
    private Email email;
}

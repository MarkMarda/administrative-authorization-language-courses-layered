package com.marda.administrative_authorization_language_courses_layered.student.entity.mysql;

import com.marda.administrative_authorization_language_courses_layered.commons.entity.constants.EntityConstants;
import com.marda.administrative_authorization_language_courses_layered.student.entity.vo.Email;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Comment(value = "Table register student candidats data")
@Entity(name = "StudentCandidatEntity")
@Table(name = EntityConstants.STUDENT_CANDIDAT)
public class StudentCandidatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_candidat_id")
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", nullable = false)
    private PersonaEntity persona;

    @Embedded
    //In case we have more VO (we need Embedded) this solving collisions
    @AttributeOverride(
            name = "value",
            column = @Column(name = "student_candidat_email")
    )
    private Email email;

    @Column(name = "student_candidat_phone_number")
    private String phoneNumber;
}

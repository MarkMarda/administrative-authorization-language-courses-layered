package com.marda.administrative_authorization_language_courses_layered.student.entity.mysql;

import com.marda.administrative_authorization_language_courses_layered.commons.entity.constants.EntityConstants;
import com.marda.administrative_authorization_language_courses_layered.student.entity.vo.Email;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
public class StudentCandidatEntity extends PersonaEntity {
    private Email email;
    private String phoneNumber;
}

package com.marda.administrative_authorization_language_courses_layered.course.entity.mysql;

import com.marda.administrative_authorization_language_courses_layered.base.entity.BaseEntity;
import com.marda.administrative_authorization_language_courses_layered.base.entity.Identifiable;
import com.marda.administrative_authorization_language_courses_layered.commons.entity.constants.EntityConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Comment(value = "Table register courses")
@Entity(name = "CourseEntity")
@Table(name = EntityConstants.COURSE)
public class CourseEntity extends BaseEntity implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "course_code")
    private String code;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_level")
    private String level;
}

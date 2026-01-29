package com.marda.administrative_authorization_language_courses_layered.student.repository.mysql.jpa;

import com.marda.administrative_authorization_language_courses_layered.commons.repository.base.BaseRepository;
import com.marda.administrative_authorization_language_courses_layered.student.dto.repository.StudentLanguagesDTO;
import com.marda.administrative_authorization_language_courses_layered.student.entity.mysql.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends BaseRepository<StudentEntity, Long> {
    // JPQL
    @Query("""
       SELECT new com.marda.administrative_authorization_language_courses_layered.student.dto.repository.StudentLanguagesDTO(
           CONCAT(p.firstName, ' ', p.firstSurname, ' ', p.secondSurname),
           l
       )
       FROM StudentEntity s
       JOIN s.persona p
       JOIN s.enrolledLanguageCourses l
       """)
    List<StudentLanguagesDTO> findStudentLanguages();

}

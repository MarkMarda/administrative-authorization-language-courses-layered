package com.marda.administrative_authorization_language_courses_layered.student.repository.mysql.jpa;

import com.marda.administrative_authorization_language_courses_layered.commons.repository.base.BaseRepository;
import com.marda.administrative_authorization_language_courses_layered.student.entity.mysql.StudentEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<StudentEntity, Long> {
}

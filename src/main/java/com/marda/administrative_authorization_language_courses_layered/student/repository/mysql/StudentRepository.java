package com.marda.administrative_authorization_language_courses_layered.student.repository.mysql;

import com.marda.administrative_authorization_language_courses_layered.commons.repository.base.BaseRepository;
import com.marda.administrative_authorization_language_courses_layered.student.entity.mysql.StudentCandidatEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<StudentCandidatEntity, Long> {
}

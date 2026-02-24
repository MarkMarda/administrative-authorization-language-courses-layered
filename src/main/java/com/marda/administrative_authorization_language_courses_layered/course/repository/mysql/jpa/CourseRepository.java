package com.marda.administrative_authorization_language_courses_layered.course.repository.mysql.jpa;

import com.marda.administrative_authorization_language_courses_layered.base.repository.BaseRepository;
import com.marda.administrative_authorization_language_courses_layered.course.entity.mysql.CourseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends BaseRepository<CourseEntity, Long> {
}

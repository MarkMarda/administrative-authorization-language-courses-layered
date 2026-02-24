package com.marda.administrative_authorization_language_courses_layered.course.service;

import com.marda.administrative_authorization_language_courses_layered.base.mapper.BaseMapper;
import com.marda.administrative_authorization_language_courses_layered.base.service.BaseServiceImpl;
import com.marda.administrative_authorization_language_courses_layered.commons.service.exception.ServiceException;
import com.marda.administrative_authorization_language_courses_layered.course.dto.request.CourseRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.course.dto.response.CourseResponseDTO;
import com.marda.administrative_authorization_language_courses_layered.course.entity.mysql.CourseEntity;
import com.marda.administrative_authorization_language_courses_layered.course.mapper.CourseMapper;
import com.marda.administrative_authorization_language_courses_layered.course.repository.mysql.jpa.CourseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl
        extends BaseServiceImpl<CourseRequestDTO, CourseResponseDTO, CourseEntity>
        implements CourseService {
    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    public CourseServiceImpl(
            CourseRepository courseRepository,
            CourseMapper courseMapper
    ) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    protected JpaRepository<CourseEntity, Long> getRepository() {
        return courseRepository;
    }

    @Override
    protected BaseMapper<CourseRequestDTO, CourseResponseDTO, CourseEntity> getMapper() {
        return courseMapper;
    }

}

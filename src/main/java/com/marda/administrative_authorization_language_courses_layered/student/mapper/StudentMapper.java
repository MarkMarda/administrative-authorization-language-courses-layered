package com.marda.administrative_authorization_language_courses_layered.student.mapper;

import com.marda.administrative_authorization_language_courses_layered.student.dto.request.StudentRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.student.dto.response.StudentResponseDTO;
import com.marda.administrative_authorization_language_courses_layered.student.entity.mysql.StudentEntity;

public interface StudentMapper {
    StudentResponseDTO toDto(StudentEntity studentEntity);

    StudentEntity toEntity(StudentRequestDTO studentRequestDTO);
}

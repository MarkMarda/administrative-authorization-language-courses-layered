package com.marda.administrative_authorization_language_courses_layered.student.mapper;

import com.marda.administrative_authorization_language_courses_layered.student.dto.request.StudentRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.student.dto.response.StudentResponseDTO;
import com.marda.administrative_authorization_language_courses_layered.student.entity.mysql.StudentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapper {
    private final ModelMapper modelMapper;

    public StudentMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentResponseDTO toDto(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentResponseDTO.class);

//        return StudentResponseDTO.builder()
//                .idCredential(studentEntity.getIdCredential())
//                .message("Student created successfully")
//                .build();
    }

    @Override
    public StudentEntity toEntity(StudentRequestDTO studentRequestDTO) {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setIdCredential(studentRequestDTO.idCredential());
        studentEntity.setPhoneNumber(studentRequestDTO.phoneNumber());
        studentEntity.setEnrolledLanguageCourses(studentRequestDTO.enrolledLanguageCourses());

        return studentEntity;
    }
}

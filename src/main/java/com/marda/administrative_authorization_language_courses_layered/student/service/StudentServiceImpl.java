package com.marda.administrative_authorization_language_courses_layered.student.service;

import com.marda.administrative_authorization_language_courses_layered.commons.mapper.persona.PersonaMapper;
import com.marda.administrative_authorization_language_courses_layered.commons.service.base.BaseServiceImpl;
import com.marda.administrative_authorization_language_courses_layered.commons.service.exception.ServiceException;
import com.marda.administrative_authorization_language_courses_layered.student.dto.request.StudentRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.student.dto.response.StudentResponseDTO;
import com.marda.administrative_authorization_language_courses_layered.student.entity.mysql.PersonaEntity;
import com.marda.administrative_authorization_language_courses_layered.student.entity.mysql.StudentEntity;
import com.marda.administrative_authorization_language_courses_layered.student.entity.vo.Email;
import com.marda.administrative_authorization_language_courses_layered.student.exception.StudentException;
import com.marda.administrative_authorization_language_courses_layered.student.mapper.StudentMapper;
import com.marda.administrative_authorization_language_courses_layered.student.repository.mysql.jpa.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentRequestDTO, StudentResponseDTO> implements StudentService {
    private final StudentRepository studentRepository;

    private final PersonaMapper personaMapper;
    private final StudentMapper studentMapper;

    private static final String MSG_STUDENT_ERROR_REGISTER = "Error student register";

    public StudentServiceImpl(
            StudentRepository studentRepository,
            PersonaMapper personaMapper,
            StudentMapper studentMapper
    ) {
        this.studentRepository = studentRepository;
        this.personaMapper = personaMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public Page<StudentResponseDTO> findLikeObject(StudentRequestDTO studentRequestDTO, Pageable pageable) throws ServiceException {
        return null;
    }

    @Override
    public Optional<StudentResponseDTO> findById(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    // Solve not data null
    @Transactional
    public Long save(StudentRequestDTO r) throws ServiceException {
        PersonaEntity personaEntity = personaMapper.toEntity(r.personalData());
        StudentEntity studentEntity = studentMapper.toEntity(r);

        // Auditing
        personaEntity.setAudRegisterDate(LocalDateTime.now());
        personaEntity.setAudRegisterIdUser(1L);
        personaEntity.setAudRegisterIp("127.0.0.1");
        personaEntity.setState("1");

        studentEntity.setPersona(personaEntity);
        // Explicit creation of VO
        studentEntity.setEmail(Email.create(r.email()));

        StudentEntity studentSaved = studentRepository.save(studentEntity);

        if (isNull(studentSaved) || isNull(studentSaved.getId())) {
            throw new StudentException(MSG_STUDENT_ERROR_REGISTER);
        }

        return studentSaved.getId();
    }

    @Override
    public Boolean update(StudentRequestDTO studentRequestDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(StudentRequestDTO studentRequestDTO) throws ServiceException {
        return null;
    }
}

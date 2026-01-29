package com.marda.administrative_authorization_language_courses_layered.student.service;

import com.marda.administrative_authorization_language_courses_layered.commons.service.base.BaseService;
import com.marda.administrative_authorization_language_courses_layered.commons.service.exception.ServiceException;
import com.marda.administrative_authorization_language_courses_layered.student.dto.repository.StudentLanguagesDTO;
import com.marda.administrative_authorization_language_courses_layered.student.dto.request.StudentRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.student.dto.response.StudentResponseDTO;

import java.util.List;

public interface StudentService extends BaseService<StudentRequestDTO, StudentResponseDTO> {
    List<StudentLanguagesDTO> findStudentLanguages() throws ServiceException;
}

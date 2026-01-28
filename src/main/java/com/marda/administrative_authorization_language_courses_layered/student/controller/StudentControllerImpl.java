package com.marda.administrative_authorization_language_courses_layered.student.controller;

import com.marda.administrative_authorization_language_courses_layered.commons.controller.base.BaseController;
import com.marda.administrative_authorization_language_courses_layered.commons.service.exception.ServiceException;
import com.marda.administrative_authorization_language_courses_layered.student.dto.request.StudentRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.student.dto.response.StudentResponseDTO;
import com.marda.administrative_authorization_language_courses_layered.student.exception.StudentException;
import com.marda.administrative_authorization_language_courses_layered.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControllerImpl extends BaseController implements StudentController {
    private final StudentService studentService;

    private static final String MESSAGE_CREATED = "El estudiante fue creado correctamente";

    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public ResponseEntity<StudentResponseDTO> findById() throws StudentException {
        return null;
    }

    @Override
    public ResponseEntity<StudentResponseDTO> save(StudentRequestDTO studentRequestDTO) throws StudentException {
        try {
            studentService.save(studentRequestDTO);

            var response = StudentResponseDTO
                    .builder()
                    .message(MESSAGE_CREATED)
                    .idCredential(studentRequestDTO.idCredential())
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ServiceException e) {
            throw new StudentException(e);
        }
    }
}

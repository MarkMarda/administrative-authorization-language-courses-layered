package com.marda.administrative_authorization_language_courses_layered.student.controller;

import com.marda.administrative_authorization_language_courses_layered.student.dto.repository.StudentLanguagesDTO;
import com.marda.administrative_authorization_language_courses_layered.student.dto.request.StudentRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.student.dto.response.StudentResponseDTO;
import com.marda.administrative_authorization_language_courses_layered.student.exception.StudentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.marda.administrative_authorization_language_courses_layered.student.constants.APIConstants.API_STUDENT;

@RequestMapping(API_STUDENT)
public interface StudentController {
    @GetMapping
    ResponseEntity<StudentResponseDTO> findById() throws StudentException;

    @GetMapping("/languages")
    ResponseEntity<List<StudentLanguagesDTO>> findStudentLanguages() throws StudentException;

    @PostMapping
    ResponseEntity<StudentResponseDTO> save(@RequestBody StudentRequestDTO studentRequestDTO) throws StudentException;
}

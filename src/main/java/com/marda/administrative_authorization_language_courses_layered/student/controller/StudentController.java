package com.marda.administrative_authorization_language_courses_layered.student.controller;

import com.marda.administrative_authorization_language_courses_layered.student.exception.StudentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.marda.administrative_authorization_language_courses_layered.student.constants.APIConstants.API_STUDENT;

@RequestMapping(API_STUDENT)
public interface StudentController {
    ResponseEntity<?> findById() throws StudentException;

    ResponseEntity<?> save() throws StudentException;
}

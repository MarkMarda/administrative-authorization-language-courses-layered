package com.marda.administrative_authorization_language_courses_layered.course.controller;

import com.marda.administrative_authorization_language_courses_layered.course.dto.request.CourseRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.course.dto.response.CourseResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.marda.administrative_authorization_language_courses_layered.course.constants.APICourseConstants.API_COURSE;

@RequestMapping(API_COURSE)
public interface CourseController {
    @PostMapping()
    ResponseEntity<CourseResponseDTO> save(@Valid @RequestBody CourseRequestDTO courseRequestDTO);
}

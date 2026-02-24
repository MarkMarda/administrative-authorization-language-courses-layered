package com.marda.administrative_authorization_language_courses_layered.course.controller;

import com.marda.administrative_authorization_language_courses_layered.base.controller.BaseController;
import com.marda.administrative_authorization_language_courses_layered.commons.service.exception.ServiceException;
import com.marda.administrative_authorization_language_courses_layered.course.dto.request.CourseRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.course.dto.response.CourseResponseDTO;
import com.marda.administrative_authorization_language_courses_layered.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseControllerImpl extends BaseController implements CourseController {
    private final CourseService courseService;

    private static final String MESSAGE_CREATED = "El curso fue creado correctamente";

    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public ResponseEntity<CourseResponseDTO> save(CourseRequestDTO courseRequestDTO) {

        var idCourse = courseService.save(courseRequestDTO);

        var response = CourseResponseDTO
                .builder()
                .message(MESSAGE_CREATED)
                .id(idCourse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

package com.marda.administrative_authorization_language_courses_layered.student.controller;

import com.marda.administrative_authorization_language_courses_layered.commons.controller.base.BaseController;
import com.marda.administrative_authorization_language_courses_layered.student.exception.StudentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControllerImpl extends BaseController implements StudentController {
    @Override
    public ResponseEntity<?> findById() throws StudentException {
        return null;
    }

    @Override
    public ResponseEntity<?> save() throws StudentException {
        return null;
    }
}

package com.marda.administrative_authorization_language_courses_layered.commons.controller.base;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {
    protected ResponseEntity<?> internalServerError(Exception e) {
        Map<String, String> response = new HashMap<>();
        response.put("err", e.getMessage());

        return ResponseEntity.internalServerError().body(response);
    }
}

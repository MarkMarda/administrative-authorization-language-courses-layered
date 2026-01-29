package com.marda.administrative_authorization_language_courses_layered.commons.controller.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

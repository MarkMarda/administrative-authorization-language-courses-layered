package com.marda.administrative_authorization_language_courses_layered.commons.controller.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime date;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.date=LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.marda.administrative_authorization_language_courses_layered.student.dto.request;

import com.marda.administrative_authorization_language_courses_layered.commons.dto.persona.PersonaDTO;

import java.util.List;

public record StudentRequestDTO(
        PersonaDTO personalData,
        Long idCredential,
        List<String> enrolledLanguageCourses,
        String phoneNumber,
        String email
) {
}

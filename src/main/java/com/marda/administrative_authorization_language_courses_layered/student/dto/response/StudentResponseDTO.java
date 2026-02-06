package com.marda.administrative_authorization_language_courses_layered.student.dto.response;

import lombok.Builder;

@Builder
public record StudentResponseDTO(
        String message,
        Long idCredential
) {
}

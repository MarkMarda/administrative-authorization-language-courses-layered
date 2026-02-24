package com.marda.administrative_authorization_language_courses_layered.course.dto.response;

import lombok.Builder;

@Builder
public record CourseResponseDTO(
        String message,
        Long id
) {
}

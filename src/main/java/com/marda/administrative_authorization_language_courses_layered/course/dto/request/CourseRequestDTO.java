package com.marda.administrative_authorization_language_courses_layered.course.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record CourseRequestDTO(
        @NotBlank
        String code,

        @NotBlank(message = "name is mandatory")
        String name,

        @NotBlank
        String level
) {
}

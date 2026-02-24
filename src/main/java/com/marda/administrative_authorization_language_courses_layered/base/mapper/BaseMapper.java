package com.marda.administrative_authorization_language_courses_layered.base.mapper;

import java.util.Optional;

public interface BaseMapper<T, R, E> {
    E toEntity(T dto);
    R toResponseDto(E entity);
    void toUpdateEntity(T dto, E entity);
}

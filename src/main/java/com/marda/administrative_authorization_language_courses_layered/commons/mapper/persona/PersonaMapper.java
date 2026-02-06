package com.marda.administrative_authorization_language_courses_layered.commons.mapper.persona;

import com.marda.administrative_authorization_language_courses_layered.commons.dto.persona.PersonaDTO;
import com.marda.administrative_authorization_language_courses_layered.student.entity.mysql.PersonaEntity;

public interface PersonaMapper {
    PersonaEntity toEntity(PersonaDTO personaDTO);
}

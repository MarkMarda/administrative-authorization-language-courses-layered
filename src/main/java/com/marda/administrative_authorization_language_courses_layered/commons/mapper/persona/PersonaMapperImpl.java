package com.marda.administrative_authorization_language_courses_layered.commons.mapper.persona;

import com.marda.administrative_authorization_language_courses_layered.commons.dto.persona.PersonaDTO;
import com.marda.administrative_authorization_language_courses_layered.student.entity.mysql.PersonaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PersonaMapperImpl implements PersonaMapper {
    private final ModelMapper modelMapper;

    public PersonaMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonaEntity toEntity(PersonaDTO personaDTO) {
        PersonaEntity personaEntity = new PersonaEntity();

        personaEntity.setFirstName(personaDTO.firstName());
        personaEntity.setMiddleName(personaDTO.middleName());
        personaEntity.setFirstSurname(personaDTO.firstSurname());
        personaEntity.setSecondSurname(personaDTO.secondSurname());
        personaEntity.setBirthDate(
                personaDTO.birthDate() != null ? LocalDate.parse(personaDTO.birthDate()) : null
        );

        return personaEntity;
    }
}

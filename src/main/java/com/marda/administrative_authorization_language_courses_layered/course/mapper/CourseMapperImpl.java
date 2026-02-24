package com.marda.administrative_authorization_language_courses_layered.course.mapper;

import com.marda.administrative_authorization_language_courses_layered.base.mapper.BaseMapperImpl;
import com.marda.administrative_authorization_language_courses_layered.course.dto.request.CourseRequestDTO;
import com.marda.administrative_authorization_language_courses_layered.course.dto.response.CourseResponseDTO;
import com.marda.administrative_authorization_language_courses_layered.course.entity.mysql.CourseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseMapperImpl
        extends BaseMapperImpl<CourseRequestDTO, CourseResponseDTO, CourseEntity>
        implements CourseMapper {

    protected CourseMapperImpl(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    protected Class<CourseEntity> getEntityClass() {
        return CourseEntity.class;
    }

    @Override
    protected Class<CourseResponseDTO> getResponseClass() {
        return CourseResponseDTO.class;
    }
    /*
    private final ModelMapper modelMapper;

    public CourseMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseEntity toEntity(CourseRequestDTO courseRequestDTO) {
        CourseEntity courseEntity = modelMapper.map(courseRequestDTO, CourseEntity.class);
        return courseEntity;
    }

    @Override
    public CourseResponseDTO toResponseDto(CourseEntity entity) {
        CourseResponseDTO courseResponseDTO = modelMapper.map(entity, CourseResponseDTO.class);
        return courseResponseDTO;
    }

    @Override
    public void toUpdateEntity(CourseRequestDTO dto, CourseEntity entity) {
        modelMapper.map(dto, entity);
    }*/

}

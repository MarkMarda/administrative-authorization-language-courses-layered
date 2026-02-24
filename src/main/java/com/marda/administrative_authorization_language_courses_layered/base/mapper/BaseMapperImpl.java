package com.marda.administrative_authorization_language_courses_layered.base.mapper;

import org.modelmapper.ModelMapper;

public abstract class BaseMapperImpl<T, R, E> implements BaseMapper<T, R, E> {
    protected final ModelMapper modelMapper;

    protected BaseMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    protected abstract Class<E> getEntityClass();

    protected abstract Class<R> getResponseClass();

    @Override
    public E toEntity(T dto) {
        return modelMapper.map(dto, getEntityClass());
    }

    @Override
    public R toResponseDto(E entity) {
        return modelMapper.map(entity, getResponseClass());
    }

    @Override
    public void toUpdateEntity(T dto, E entity) {
        modelMapper.map(dto, entity);
    }
}

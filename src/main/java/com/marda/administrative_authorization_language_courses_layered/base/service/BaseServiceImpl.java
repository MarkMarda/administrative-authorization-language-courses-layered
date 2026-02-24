package com.marda.administrative_authorization_language_courses_layered.base.service;

import com.marda.administrative_authorization_language_courses_layered.base.entity.BaseEntity;
import com.marda.administrative_authorization_language_courses_layered.base.entity.Identifiable;
import com.marda.administrative_authorization_language_courses_layered.base.mapper.BaseMapper;
import com.marda.administrative_authorization_language_courses_layered.commons.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public abstract class BaseServiceImpl<T, R, E extends BaseEntity & Identifiable> implements BaseService<T, R> {
    protected abstract JpaRepository<E, Long> getRepository();

    protected abstract BaseMapper<T, R, E> getMapper();

    private final static String ERROR_MESSAGE_RETRIEVING_ENTITY = "Error retrieving entity";
    private final static String ERROR_MESSAGE_SAVING_ENTITY = "Error saving entity";
    private final static String ERROR_MESSAGE_ENTITY_NOT_FOUND = "Entity not found";
    private final static String ERROR_MESSAGE_UPDATING_ENTITY = "Error updating entity";
    private final static String ERROR_MESSAGE_DELETING_ENTITY = "Error deleting entity";

    @Override
    public Page<R> findLikeObject(T t, Pageable pageable) throws ServiceException {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<R> findById(Long id) throws ServiceException {
        try {
            return getRepository()
                    .findById(id)
                    .map(entity -> getMapper().toResponseDto(entity));
        } catch (Exception e) {
            throw new ServiceException(ERROR_MESSAGE_RETRIEVING_ENTITY,e);
        }
    }

    @Override
    @Transactional
    public Long save(T r) throws ServiceException {
        try {
            E entity = getMapper().toEntity(r);
            E saved = getRepository().save(entity);

            return saved.getId();
        } catch (Exception e) {
            throw new ServiceException(ERROR_MESSAGE_SAVING_ENTITY, e);
        }
    }

    @Override
    @Transactional
    public R update(Long id, T t) throws ServiceException {
        try {
            E entiy = getRepository()
                    .findById(id)
                    .orElseThrow(() -> new ServiceException(ERROR_MESSAGE_ENTITY_NOT_FOUND));

            getMapper().toUpdateEntity(t, entiy);
            E saved = getRepository().save(entiy);

            return getMapper().toResponseDto(saved);
        } catch (Exception e) {
            throw new ServiceException(ERROR_MESSAGE_UPDATING_ENTITY, e);
        }
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        try {
            E entiy = getRepository()
                    .findById(id)
                    .orElseThrow(() -> new ServiceException(ERROR_MESSAGE_ENTITY_NOT_FOUND));

            getRepository().delete(entiy);

            return true;
        } catch (Exception e) {
            throw new ServiceException(ERROR_MESSAGE_DELETING_ENTITY, e);
        }
    }

}

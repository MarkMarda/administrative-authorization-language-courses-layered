package com.marda.administrative_authorization_language_courses_layered.base.service;

import com.marda.administrative_authorization_language_courses_layered.commons.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BaseService<T, R> {
    Page<R> findLikeObject(T t, Pageable pageable) throws ServiceException;

    Optional<R> findById(Long id) throws ServiceException;

    Long save(T r) throws ServiceException;

    R update(Long id, T t) throws ServiceException;

    Boolean delete(Long id) throws ServiceException;
}

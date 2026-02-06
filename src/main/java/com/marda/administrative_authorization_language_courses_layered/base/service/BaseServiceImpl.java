package com.marda.administrative_authorization_language_courses_layered.base.service;

import com.marda.administrative_authorization_language_courses_layered.commons.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class BaseServiceImpl<T, R> implements BaseService<T, R> {
    @Override
    public Page<R> findLikeObject(T t, Pageable pageable) throws ServiceException {
        return null;
    }

    @Override
    public Optional<R> findById(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Long save(T r) throws ServiceException {
        return 0L;
    }

    @Override
    public Boolean update(T t) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(T t) throws ServiceException {
        return null;
    }
}

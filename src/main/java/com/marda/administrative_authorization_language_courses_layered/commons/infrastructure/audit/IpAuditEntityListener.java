package com.marda.administrative_authorization_language_courses_layered.commons.infrastructure.audit;

import com.marda.administrative_authorization_language_courses_layered.base.entity.BaseEntity;
import com.marda.administrative_authorization_language_courses_layered.commons.infrastructure.context.RequestContextProvider;
import com.marda.administrative_authorization_language_courses_layered.commons.infrastructure.context.SpringContextHolder;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class IpAuditEntityListener {
    @PrePersist
    public void setIpBeforeInsert(BaseEntity entity) {

        RequestContextProvider provider =
                SpringContextHolder.getBean(RequestContextProvider.class);

        entity.setAudRegisterIp(provider.getCurrentIp());
        entity.setState("1");
    }

    @PreUpdate
    public void setIpBeforeUpdate(BaseEntity entity) {

        RequestContextProvider provider =
                SpringContextHolder.getBean(RequestContextProvider.class);

        entity.setAudLastModifiedIp(provider.getCurrentIp());
    }
}

package com.marda.administrative_authorization_language_courses_layered.base.entity;

import com.marda.administrative_authorization_language_courses_layered.commons.infrastructure.audit.IpAuditEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners({
        AuditingEntityListener.class,
        IpAuditEntityListener.class
})
@AllArgsConstructor
public class BaseEntity {
    @CreatedDate
    @Column(name = "aud_register_date", nullable = false, updatable = false)
    private LocalDateTime audRegisterDate;

    @LastModifiedDate
    @Column(name = "aud_last_modified_date", nullable = false)
    private LocalDateTime audLastModifiedDate;

    @CreatedBy
    @Column(name = "aud_register_id_user", nullable = false, updatable = false)
    private Long audRegisterIdUser;

    @LastModifiedBy
    @Column(name = "aud_last_modified_id_user", nullable = false)
    private Long audLastModifiedIdUser;

    @Column(name = "aud_register_ip", nullable = false, updatable = false)
    private String audRegisterIp;

    @Column(name = "aud_last_modified_ip")
    private String audLastModifiedIp;

    @Column(name = "state", nullable = false, length = 1)
    private String state;

    public BaseEntity() {
    }

    public LocalDateTime getAudRegisterDate() {
        return audRegisterDate;
    }

    public void setAudRegisterDate(LocalDateTime audRegisterDate) {
        this.audRegisterDate = audRegisterDate;
    }

    public Long getAudRegisterIdUser() {
        return audRegisterIdUser;
    }

    public void setAudRegisterIdUser(Long audRegisterIdUser) {
        this.audRegisterIdUser = audRegisterIdUser;
    }

    public String getAudRegisterIp() {
        return audRegisterIp;
    }

    public void setAudRegisterIp(String audRegisterIp) {
        this.audRegisterIp = audRegisterIp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

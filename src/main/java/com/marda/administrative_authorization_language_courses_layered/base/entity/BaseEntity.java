package com.marda.administrative_authorization_language_courses_layered.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@AllArgsConstructor
public class BaseEntity {
    @Column(name = "aud_register_date", nullable = false)
    private LocalDateTime audRegisterDate;

    @Column(name = "aud_register_id_user", nullable = false)
    private Long audRegisterIdUser;

    @Column(name = "aud_register_ip", nullable = false)
    private String audRegisterIp;

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

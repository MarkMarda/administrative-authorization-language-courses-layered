package com.marda.administrative_authorization_language_courses_layered.commons.infrastructure.context;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static java.util.Objects.isNull;

@Component
public class RequestContextProvider {
    public String getCurrentIp() {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (isNull(attributes)) {
            return "SYSTEM";
        }

        HttpServletRequest request = attributes.getRequest();

        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.isBlank()) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}

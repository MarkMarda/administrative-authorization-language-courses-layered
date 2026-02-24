package com.marda.administrative_authorization_language_courses_layered.commons.infrastructure.audit;

import com.marda.administrative_authorization_language_courses_layered.commons.infrastructure.security.CustomUserDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        // TODO:
        //return Optional.of(1L);

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of(0L); // SYSTEM
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserDetails user) {
            return Optional.of(user.getId());
        }

        return Optional.of(1L); // TODO temporal change to 0L
    }
}

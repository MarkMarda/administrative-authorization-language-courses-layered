package com.marda.administrative_authorization_language_courses_layered.student.entity.vo;

import com.marda.administrative_authorization_language_courses_layered.student.exception.StudentException;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    private String value;

    // OWASP Validation Regular Expression
    // https://www.baeldung.com/java-email-validation-regex
    private static final String REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String EMAIL_REQUIRED = "Email required";
    private static final String EMAIL_NOT_VALID = "Email is not valid";

    // Required for JPA
    protected Email() {
    }

    private Email(String value) {
        this.value = value;
    }

    public static Email create(String value) throws StudentException {
        if (value == null || value.isBlank()) {
            throw new StudentException(EMAIL_REQUIRED);
        }

        if (!value.matches(REGEX)) {
            throw new StudentException(EMAIL_NOT_VALID);
        }

        return new Email(value);
    }

    /**
     * Factory used when reconstructing domain objects
     * from persisted state (e.g., database records).
     *
     * Throws IllegalStateException if persisted data is invalid.
     */
    public static Email fromDb(String value) {
        try {
            return create(value);
        } catch (StudentException e) {
            throw new IllegalStateException("Invalid email in DB", e);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }
}

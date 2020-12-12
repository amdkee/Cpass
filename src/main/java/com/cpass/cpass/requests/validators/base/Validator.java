package com.cpass.cpass.requests.validators.base;

import com.cpass.cpass.exceptions.CpassError;
import com.cpass.cpass.exceptions.CpassException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laughmare
 * @param <T>
 */
public abstract class Validator<T> {

    private List<CpassError> errors;

    public Validator() {
        clearError();
    }

    public void validate(T body) {
        if (body == null) {
            addValidationError("Body should not be empty");
        }
        throwIfError();
    }

    protected void addValidationError(String... messages) {
        errors.add(new CpassError("Validation Exception", messages));
    }

    protected void throwIfError() {
        if (!errors.isEmpty()) {
            throw new CpassException(errors);
        }
    }

    protected void clearError() {
        errors = new ArrayList<>();
    }
}

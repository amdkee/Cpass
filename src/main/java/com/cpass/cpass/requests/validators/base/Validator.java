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

    //Clear error method also initialized errors list.
    public Validator() {
        clearError();
    }

    //At least a null check is given to this validation
    public void validate(T body) {
        if (body == null) {
            addValidationError("Body should not be empty");
        }
        throwIfError();
    }

    //since we only do validations here the error for our exception is fixed
    protected void addValidationError(String... messages) {
        errors.add(new CpassError("Validation Exception", messages));
    }

    //simply throw the error if the error list is not empty
    protected void throwIfError() {
        if (!errors.isEmpty()) {
            throw new CpassException(errors);
        }
    }

    //clear errors before validating the call
    protected void clearError() {
        errors = new ArrayList<>();
    }
}

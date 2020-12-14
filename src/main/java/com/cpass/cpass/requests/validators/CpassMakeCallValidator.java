package com.cpass.cpass.requests.validators;

import java.util.Locale;

import com.cpass.cpass.requests.validators.base.Validator;
import com.cpass.cpass.enums.CallType;
import com.cpass.cpass.requests.MakeCallRequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Laughmare
 */
public class CpassMakeCallValidator extends Validator<MakeCallRequestBody> {

    Logger logger = LoggerFactory.getLogger(CpassMakeCallValidator.class);

    public CpassMakeCallValidator() {
        super();
    }

    //If the provided call type string is not in our enums do not throw an error. but catch it and return false 
    private Boolean validateCallType(String callType) {
        try {
            CallType.valueOf(callType.toUpperCase(Locale.getDefault()));
        } catch (IllegalArgumentException ex) {
            logger.error(ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            logger.error(ex.getMessage());
            return false;
        }
        return true;
    }

    //actual validations are done here. Errors are added to a list, and than inserted into the exception message list.
    @Override
    public void validate(MakeCallRequestBody body) {
        clearError();
        if (body == null || body.getCallType() == null || body.getCallType().trim().isEmpty()) {
            addValidationError("Call type(callType) is required");
        }
        if (body == null || body.getCaller() == null || body.getCaller().trim().isEmpty()) {
            addValidationError("Caller(caller) is required");
        }
        if (body == null || body.getCally() == null || body.getCally().trim().isEmpty()) {
            addValidationError("Cally(cally) is required");
        }
        if (body != null && body.getCallType() != null && !validateCallType(body.getCallType())) {
            addValidationError("Invalid call type",
                    "    Valid call types are:",
                    "       -Regular",
                    "       -Anonymous",
                    "       -X");
        }
        throwIfError();
    }
}

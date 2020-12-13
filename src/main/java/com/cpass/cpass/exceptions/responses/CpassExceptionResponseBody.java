package com.cpass.cpass.exceptions.responses;

import com.cpass.cpass.exceptions.CpassError;
import com.cpass.cpass.exceptions.responses.base.ExceptionResponseBody;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Laughmare
 */
@Getter
@Setter
public class CpassExceptionResponseBody extends ExceptionResponseBody {

    List<CpassError> errors;

    public CpassExceptionResponseBody(List<CpassError> errors, Date timeStamp, String path) {
        super(timeStamp, path);
        this.errors = errors;
    }
}

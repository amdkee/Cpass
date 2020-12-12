package com.cpass.cpass.exceptions.responses;

import com.cpass.cpass.exceptions.responses.base.BaseExceptionResponseBody;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Laughmare
 */
@Getter
@Setter
public class ExceptionResponseBody extends BaseExceptionResponseBody {

    String message;

    public ExceptionResponseBody(String message, Date timeStamp, String path) {
        super(timeStamp, path);
        this.message = message;
    }
}

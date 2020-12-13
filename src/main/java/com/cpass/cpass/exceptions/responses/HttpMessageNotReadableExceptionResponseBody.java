package com.cpass.cpass.exceptions.responses;

import com.cpass.cpass.exceptions.responses.base.ExceptionResponseBody;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Laughmare
 */
@Getter
@Setter
public class HttpMessageNotReadableExceptionResponseBody extends ExceptionResponseBody {

    String message;

    public HttpMessageNotReadableExceptionResponseBody(String message, Date timeStamp, String path) {
        super(timeStamp, path);
        this.message = message;
    }
}

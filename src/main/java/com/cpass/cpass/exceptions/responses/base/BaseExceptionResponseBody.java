package com.cpass.cpass.exceptions.responses.base;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Laughmare
 */
@Getter
@Setter
public class BaseExceptionResponseBody {

    Date timeStamp;
    String path;

    public BaseExceptionResponseBody(Date timeStamp, String path) {
        this.timeStamp = timeStamp;
        this.path = path;
    }

}

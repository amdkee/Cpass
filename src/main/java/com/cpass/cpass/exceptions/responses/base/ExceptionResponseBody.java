package com.cpass.cpass.exceptions.responses.base;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Laughmare
 */
//Any handled exception will have a path, and a timestamp
@Getter
@Setter
public class ExceptionResponseBody {
    Date timeStamp;
    String path;

    public ExceptionResponseBody(Date timeStamp, String path) {
        this.timeStamp = timeStamp;
        this.path = path;
    }

}

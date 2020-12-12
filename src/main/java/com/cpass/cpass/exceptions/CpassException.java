package com.cpass.cpass.exceptions;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Laughmare
 */
@Getter
@Setter
public class CpassException extends RuntimeException {

    List<CpassError> errors;

    public CpassException(List<CpassError> errors) {
        this.errors = errors;
    }
}

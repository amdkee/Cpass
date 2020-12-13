package com.cpass.cpass.exceptions;

import java.util.List;
import java.util.Objects;
import lombok.EqualsAndHashCode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Laughmare
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CpassException extends RuntimeException {

    List<CpassError> errors;

    public CpassException(List<CpassError> errors) {
        this.errors = errors;
    }
}

package com.cpass.cpass.exceptions;

import java.util.List;
import lombok.EqualsAndHashCode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Laughmare
 */

//Our custom exception to handle valdiations and other things as we wish.
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

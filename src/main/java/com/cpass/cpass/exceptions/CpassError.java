package com.cpass.cpass.exceptions;

import lombok.Value;

/**
 *
 * @author Laughmare
 */
@Value
public class CpassError {

    String error;
    String[] messages;
}

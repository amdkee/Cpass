/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CpassException extends RuntimeException{
    
    private final List<CpassError> errors;
    
    public CpassException(List<CpassError> errors) {
        this.errors = errors;
    }    
}

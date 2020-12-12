/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpass.cpass.exceptions;

import java.util.List;
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

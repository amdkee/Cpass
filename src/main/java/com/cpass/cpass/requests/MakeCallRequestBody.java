/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpass.cpass.requests;

import lombok.Value;

/**
 *
 * @author Laughmare
 */
@Value
public class MakeCallRequestBody {
    String caller;
    String cally;
    String callType;
}

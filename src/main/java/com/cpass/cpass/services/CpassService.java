/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpass.cpass.services;

import com.cpass.cpass.requests.MakeCallRequestBody;
import com.cpass.cpass.responses.MakeCallResponseBody;

/**
 *
 * @author Laughmare
 */
public interface CpassService {
    
    MakeCallResponseBody makeCall(MakeCallRequestBody body);
}

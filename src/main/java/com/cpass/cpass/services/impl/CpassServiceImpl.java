/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpass.cpass.services.impl;

import org.springframework.stereotype.Service;

import com.cpass.cpass.services.CpassService;
import com.cpass.cpass.requests.MakeCallRequestBody;
import com.cpass.cpass.validators.base.Validator;
import com.cpass.cpass.validators.CpassMakeCallValidator;
import com.cpass.cpass.responses.MakeCallResponseBody;

/**
 *
 * @author Laughmare
 */
@Service
public class CpassServiceImpl implements CpassService{
    
    Validator makeCallvalidator;

    public CpassServiceImpl() {
        this.makeCallvalidator = new CpassMakeCallValidator();
    }
    
    @Override
    public MakeCallResponseBody makeCall(MakeCallRequestBody body) {
        makeCallvalidator.validate(body);
        return forgeMakeCallResponseBody(body.getCallType());
    }
    
    private MakeCallResponseBody forgeMakeCallResponseBody(String callType){
        MakeCallResponseBody response = new MakeCallResponseBody("Hello this is " + callType);
        return response;
    }
}

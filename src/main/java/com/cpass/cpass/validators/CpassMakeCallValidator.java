/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpass.cpass.validators;

import java.util.Locale;

import com.cpass.cpass.validators.base.Validator;
import com.cpass.cpass.enums.CallType;
import com.cpass.cpass.requests.MakeCallRequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Laughmare
 */
public class CpassMakeCallValidator extends Validator<MakeCallRequestBody>{
    
    Logger logger = LoggerFactory.getLogger(CpassMakeCallValidator.class);

    public CpassMakeCallValidator() {
        super();
    }
    
    private Boolean validateCallType(String callType) {
        try{
            CallType.valueOf(callType.toUpperCase(Locale.getDefault()));
        }catch(IllegalArgumentException ex){
            logger.error(ex.getMessage());
            return false;
        }catch(NullPointerException ex){
            logger.error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void validate(MakeCallRequestBody body){
        clearError();
        if(body == null || body.getCallType() == null || body.getCallType().trim().isEmpty()){
            addValidationError("Call type(callType) is required");
        }
        if(body == null || body.getCaller() == null || body.getCaller().trim().isEmpty()){
            addValidationError("Caller(caller) is required");
        }
        if(body == null || body.getCally() == null || body.getCally().trim().isEmpty()){
            addValidationError("Cally(cally) is required");
        }
        if(body != null && body.getCallType() != null && !validateCallType(body.getCallType())){
            addValidationError("Invalid call type", 
                    "    Valid call types are:", 
                    "       -Regular", 
                    "       -Anonymous",
                    "       -X");
        }
        throwIfError();
    }
}

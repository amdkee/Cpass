/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpass.cpass.helpers;

import com.cpass.cpass.requests.MakeCallRequestBody;
import com.cpass.cpass.responses.MakeCallResponseBody;
import com.cpass.cpass.exceptions.CpassException;
import com.cpass.cpass.exceptions.CpassError;
import com.cpass.cpass.helpers.base.TestHelper;

/**
 *
 * @author Laughmare
 */
public class MakeCallTestHelper extends TestHelper{
    
//  ----------------------------------------------------------------------------
    
    public MakeCallRequestBody buildSuccessfulRequestBody(){
        return new MakeCallRequestBody("caller", "cally", "X");
    }
    
    public MakeCallResponseBody buildSuccessfulResponse(){
        return new MakeCallResponseBody("Hello this is X");
    }
//  ----------------------------------------------------------------------------

    public MakeCallRequestBody buildRequestBodyWithNullCaller(){
        return new MakeCallRequestBody(null, "cally", "X");
    }
    
    public CpassException buildExceptionAfterNullCaller(){
        errorList.add(buildValidationError("Caller(caller) is required"));
        return new CpassException(errorList);
    }
//  ----------------------------------------------------------------------------

    public MakeCallRequestBody buildRequestBodyWithNullCally(){
        return new MakeCallRequestBody("caller", null, "X");
    }
    
    public CpassException buildExceptionAfterNullCally(){
        errorList.add(buildValidationError("Cally(cally) is required"));
        return new CpassException(errorList);
    }
//  ----------------------------------------------------------------------------

    public MakeCallRequestBody buildRequestBodyWithNullCallType(){
        return new MakeCallRequestBody("caller", "cally", null);
    }
    
    public CpassException buildExceptionAfterNullCallType(){
        errorList.add(buildValidationError("Call type(callType) is required"));
        return new CpassException(errorList);
    }
//  ----------------------------------------------------------------------------

    public MakeCallRequestBody buildRequestBodyWithInvalidCallType(){
        return new MakeCallRequestBody("caller", "cally", "XX");
    }
    
    public CpassException buildExceptionafterInvalidCallType(){
        errorList.add(buildValidationError("Invalid call type",
                    "    Valid call types are:",
                    "       -Regular",
                    "       -Anonymous",
                    "       -X"));
        return new CpassException(errorList);
    }
//  ----------------------------------------------------------------------------

    public MakeCallRequestBody buildNullBody(){
        return null;
    }
    
    public CpassException buildExceptionAfterNullBody(){
        errorList.add(buildValidationError("Call type(callType) is required"));
        errorList.add(buildValidationError("Caller(caller) is required"));
        errorList.add(buildValidationError("Cally(cally) is required"));
        return new CpassException(errorList);
    }
//  ----------------------------------------------------------------------------
    
    private CpassError buildValidationError(String... messages) {
        return buildError("Validation Exception", messages);
    }
}

package com.cpass.cpass.services.impl;

import org.springframework.stereotype.Service;

import com.cpass.cpass.services.CpassService;
import com.cpass.cpass.requests.MakeCallRequestBody;
import com.cpass.cpass.requests.validators.base.Validator;
import com.cpass.cpass.requests.validators.CpassMakeCallValidator;
import com.cpass.cpass.responses.MakeCallResponseBody;

/**
 *
 * @author Laughmare
 */
@Service
public class CpassServiceImpl implements CpassService {

    Validator makeCallvalidator;

    public CpassServiceImpl() {
        this.makeCallvalidator = new CpassMakeCallValidator();
    }

    @Override
    public MakeCallResponseBody makeCall(MakeCallRequestBody body) {
        //If validations fail an exception will be thrown
        makeCallvalidator.validate(body);
        return buildMakeCallResponseBody(body.getCallType());
    }

    //response is built here
    private MakeCallResponseBody buildMakeCallResponseBody(String callType) {
        MakeCallResponseBody response = new MakeCallResponseBody("Hello this is " + callType);
        return response;
    }
}

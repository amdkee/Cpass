package com.cpass.cpass;

import com.cpass.cpass.responses.MakeCallResponseBody;
import com.cpass.cpass.services.CpassService;
import com.cpass.cpass.exceptions.CpassException;
import com.cpass.cpass.helpers.MakeCallTestHelper;
import com.cpass.cpass.exceptions.CpassError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

//Test method names are quite self explanatory.
@SpringBootTest
class MakeCallTests {

    private MakeCallTestHelper helper = new MakeCallTestHelper();

    @Autowired
    private CpassService service;
    
    //Error list is cleared before each test
    @BeforeEach
    private void beforeEach(){
        helper.setErrorList(new ArrayList<CpassError>());
    }
    
    @Test
    public void successfulMakeCall() throws Exception {
        MakeCallResponseBody response = service.makeCall(helper.buildSuccessfulRequestBody());
        assertEquals(helper.buildSuccessfulResponse(), response);
    }
    
    @Test
    public void unsuccessfulMakeCallRequestWithNullCaller() throws Exception {
        Throwable exception = assertThrows(CpassException.class, () -> 
                service.makeCall(helper.buildRequestBodyWithNullCaller()));
        assertEquals(helper.buildExceptionAfterNullCaller(), exception);
    }
    
    @Test
    public void unsuccessfulMakeCallRequestWithNullCally() throws Exception {
        Throwable exception = assertThrows(CpassException.class, () -> 
                service.makeCall(helper.buildRequestBodyWithNullCally()));
        assertEquals(helper.buildExceptionAfterNullCally(), exception);
    }
    
    @Test
    public void unsuccessfulMakeCallRequestWithNullCallType() throws Exception {
        Throwable exception = assertThrows(CpassException.class, () -> 
                service.makeCall(helper.buildRequestBodyWithNullCallType()));
        assertEquals(helper.buildExceptionAfterNullCallType(), exception);
    }
    
    @Test
    public void unsuccessfulMakeCallRequestWithInvalidCallType() throws Exception {
        Throwable exception = assertThrows(CpassException.class, () -> 
                service.makeCall(helper.buildRequestBodyWithInvalidCallType()));
        assertEquals(helper.buildExceptionafterInvalidCallType(), exception);
    }
    
    @Test
    public void unsuccessfulMakeCallRequestWithNullBody() throws Exception {
        Throwable exception = assertThrows(CpassException.class, () -> 
                service.makeCall(helper.buildNullBody()));
        assertEquals(helper.buildExceptionAfterNullBody(), exception);
    }
}

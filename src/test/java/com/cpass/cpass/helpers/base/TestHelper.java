/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpass.cpass.helpers.base;

import com.cpass.cpass.exceptions.CpassError;

import java.util.List;

/**
 *
 * @author Laughmare
 */
public class TestHelper {
    
    protected List<CpassError> errorList;
    
    protected CpassError buildError(String error, String... messages) {
        return new CpassError(error, messages);
    }

    public List<CpassError> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<CpassError> errorList) {
        this.errorList = errorList;
    }
}

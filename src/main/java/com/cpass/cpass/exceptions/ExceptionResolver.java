/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpass.cpass.exceptions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Laughmare
 */
@ControllerAdvice
public class ExceptionResolver {
    
    Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);
    
    @ExceptionHandler(CpassException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseBody resolveAndWriteCpassException(CpassException exception, HttpServletRequest request){
        logger.error(exception.getErrors().toString());
        return new ExceptionResponseBody(new Date(), exception.getErrors(), request.getRequestURI());
    }
        
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponseBody resolveAndWriteException(Exception exception, HttpServletRequest request){
        logger.error(exception.getMessage());
        CpassError error = new CpassError("Exception", new String[]{exception.getMessage()});
        return new ExceptionResponseBody(new Date(), List.of(error), request.getRequestURI());
    }
}

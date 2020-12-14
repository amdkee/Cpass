package com.cpass.cpass.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cpass.cpass.exceptions.responses.CpassExceptionResponseBody;
import com.cpass.cpass.exceptions.responses.HttpMessageNotReadableExceptionResponseBody;
import com.cpass.cpass.exceptions.responses.base.ExceptionResponseBody;
import org.springframework.http.converter.HttpMessageNotReadableException;

/**
 *
 * @author Laughmare
 */
@ControllerAdvice
public class ExceptionResolver {

    Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    //if a CpassException is thrown this method will handle the response.
    @ExceptionHandler(CpassException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//will return an internal server error(500)
    public ExceptionResponseBody resolveAndWriteCpassException(CpassException exception, HttpServletRequest request) {
        logger.error(exception.getErrors().toString());
        return new CpassExceptionResponseBody(exception.getErrors(), new Date(), request.getRequestURI());
    }


    //if a HttpMessageNotReadableException is thrown this method will handle the response. This happens when the request body has parsing errors
    @ExceptionHandler(HttpMessageNotReadableException.class)//will return a bad request error(400)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponseBody resolveAndWriteException(HttpMessageNotReadableException exception, HttpServletRequest request) {
        logger.error(exception.getMessage());
        return new HttpMessageNotReadableExceptionResponseBody(exception.getMessage(), new Date(), request.getRequestURI());
    }
}

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

    @ExceptionHandler(CpassException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseBody resolveAndWriteCpassException(CpassException exception, HttpServletRequest request) {
        logger.error(exception.getErrors().toString());
        return new CpassExceptionResponseBody(exception.getErrors(), new Date(), request.getRequestURI());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponseBody resolveAndWriteException(HttpMessageNotReadableException exception, HttpServletRequest request) {
        logger.error(exception.getMessage());
        return new HttpMessageNotReadableExceptionResponseBody(exception.getMessage(), new Date(), request.getRequestURI());
    }
}

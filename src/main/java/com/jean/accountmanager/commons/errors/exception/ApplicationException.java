package com.jean.accountmanager.commons.errors.exception;

import com.jean.accountmanager.commons.errors.i18n.MessageProperties;
import com.jean.accountmanager.commons.errors.response.ErrorResponse;
import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {
    private final ErrorResponse errorResponse;

    private MessageProperties messageProperties;

    private final HttpStatus httpStatus;

    protected ApplicationException(HttpStatus status, MessageProperties messageProperties, Throwable cause) {
        this(new ErrorResponse(),messageProperties, status, cause);
    }

    private ApplicationException(ErrorResponse errorResponse, MessageProperties messageProperties, HttpStatus httpStatus, Throwable cause) {
        super(errorResponse.toString(), cause);
        this.errorResponse = errorResponse;
        this.httpStatus = httpStatus;
        this.messageProperties = messageProperties;
    }

    public ErrorResponse getErrorResponse() {
        return this.errorResponse;
    }
    public MessageProperties getMessageProperties(){
        return this.messageProperties;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}

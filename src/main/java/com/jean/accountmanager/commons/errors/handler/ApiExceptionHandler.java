package com.jean.accountmanager.commons.errors.handler;

import com.jean.accountmanager.commons.errors.exception.ApplicationException;
import com.jean.accountmanager.commons.errors.i18n.Message;
import com.jean.accountmanager.commons.errors.i18n.MessageProperties;
import com.jean.accountmanager.commons.errors.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ApiExceptionHandler {
    private final Message messageService;

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected  ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        log.debug("ConstraintViolationException : {}",ex);
        List<ErrorResponse> body = populateErrors(ex.getBindingResult());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(body);
    }

    @ExceptionHandler({ ApplicationException.class })
    public ResponseEntity<Object> handleApplicationException(ApplicationException exception, WebRequest request) {
        log.error("Application Exception ", exception);

        ErrorResponse errorResponse = exception.getErrorResponse();

        if(exception.getMessageProperties() != null) {
            errorResponse.setMessage(messageService.get(exception.getMessageProperties()));
            errorResponse.setCode(exception.getMessageProperties().getCode());
        }

        return ResponseEntity.status(exception.getHttpStatus()).body(Arrays.asList(errorResponse));
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> internalServerErrorExceptionHandler(Exception ex, WebRequest request) {


        ErrorResponse body = new ErrorResponse().withCode(MessageProperties.INTERNAL_SERVER_ERROR.toString())
                .withMessage(messageService.get(MessageProperties.INTERNAL_SERVER_ERROR));

        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Arrays.asList(body));
    }

    private List<ErrorResponse> populateErrors(BindingResult bindingResult) {
        List<ErrorResponse> errorsList = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String code = messageService.getCode(fieldError);
            ErrorResponse error = new ErrorResponse()
                    .withMessage(messageService.get(MessageProperties.findByCode(code)))
                    .withCode(code);

            errorsList.add(error);
        }
        return errorsList;
    }

}

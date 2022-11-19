package com.jean.accountmanager.manager.domain.exception;

import com.jean.accountmanager.commons.errors.exception.ApplicationException;
import com.jean.accountmanager.commons.errors.i18n.MessageProperties;
import org.springframework.http.HttpStatus;

public class AccountNotFound extends ApplicationException {

    public AccountNotFound() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, MessageProperties.ACCOUNT_NOT_FOUND, null);
    }
}

package com.jean.accountmanager.commons.errors.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class Message {


    private final MessageSourceAccessor accessor;

    public Message(MessageSource messageSource) {
        this.accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
    }

    public String get(MessageProperties messageProp) {
        return accessor.getMessage(messageProp.toString(), LocaleContextHolder.getLocale());
    }

    public String get(MessageSourceResolvable resolvable) {
        return get(MessageProperties.findByCode(getCode(resolvable)));
    }
    public String getCode(MessageSourceResolvable resolvable){
        return accessor.getMessage(resolvable, LocaleContextHolder.getLocale());
    }

}

package com.jean.accountmanager.commons.errors.i18n;

public enum MessageProperties {
    API_FIELDS_INVALID("1001"),
    INTERNAL_SERVER_ERROR("1002"),
    ACCOUNT_NOT_FOUND("1003"),
    DOCUMENT_IN_USE("1004"),
    INVALID_TRANSACTION_TYPE("1005"),
    INVALID_TRANSACTION_VALUE("1006");

    public final String code;

    MessageProperties(String code) {
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }

    public static MessageProperties findByCode(String code){
        for(MessageProperties messageProperties : values()){
            if( messageProperties.getCode().equals(code)){
                return messageProperties;
            }
        }
        return API_FIELDS_INVALID;
    }
}

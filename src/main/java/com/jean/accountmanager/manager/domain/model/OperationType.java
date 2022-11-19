package com.jean.accountmanager.manager.domain.model;

import lombok.Getter;

@Getter
public enum OperationType {
    PURCHASE (1),
    INSTALLMENT_PURCHASE(2),
    WITHDRAWAL (3),
    PAYMENT (4);

    private Integer value;

    private OperationType(Integer value){
        this.value = value;
    }
}

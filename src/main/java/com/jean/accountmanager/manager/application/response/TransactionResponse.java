package com.jean.accountmanager.manager.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionResponse {

    @JsonProperty("transaction_id")
    Integer id;
    @JsonProperty("account_id")
    Integer accountId;
    @JsonProperty("operation_type_id")
    Integer operationTypeId;
    Double amount;
}

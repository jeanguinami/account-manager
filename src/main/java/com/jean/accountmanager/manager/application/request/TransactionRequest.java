package com.jean.accountmanager.manager.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TransactionRequest {

    @NotBlank
    @JsonProperty("account_id")
    Integer id;

    @NotBlank
    @JsonProperty("operation_type_id")
    Integer operationTypeId;

    @NotBlank
    Double amount;
}

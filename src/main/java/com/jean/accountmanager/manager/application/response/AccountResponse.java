package com.jean.accountmanager.manager.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountResponse {

    @JsonProperty("account_id")
    Integer id;
    @JsonProperty("document_number")
    String docNumber;
}

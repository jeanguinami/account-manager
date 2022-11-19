package com.jean.accountmanager.manager.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountRequest {

    @NotBlank
    @JsonProperty("document_number")
    String docNumber;
}

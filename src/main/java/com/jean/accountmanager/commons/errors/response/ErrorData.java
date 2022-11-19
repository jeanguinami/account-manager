package com.jean.accountmanager.commons.errors.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorData {

    private String field;

    private String message;

    private Object value;
}

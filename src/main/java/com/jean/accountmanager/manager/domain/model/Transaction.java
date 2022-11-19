package com.jean.accountmanager.manager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    Integer id;
    Account account;
    OperationType operationType;
    Double amount;
    LocalDate eventDate;
}

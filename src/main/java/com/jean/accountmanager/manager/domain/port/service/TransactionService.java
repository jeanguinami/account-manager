package com.jean.accountmanager.manager.domain.port.service;

import com.jean.accountmanager.manager.domain.model.Transaction;

public interface TransactionService {
    Transaction createTransaction(Transaction toDomain);
}

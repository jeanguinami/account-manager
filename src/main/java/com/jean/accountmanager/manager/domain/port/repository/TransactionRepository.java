package com.jean.accountmanager.manager.domain.port.repository;

import com.jean.accountmanager.manager.domain.model.Transaction;

public interface TransactionRepository {
    Transaction createTransaction(Transaction transaction);
}

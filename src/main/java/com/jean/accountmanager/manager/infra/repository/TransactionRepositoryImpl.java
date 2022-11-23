package com.jean.accountmanager.manager.infra.repository;

import com.jean.accountmanager.manager.domain.model.Transaction;
import com.jean.accountmanager.manager.domain.port.repository.TransactionRepository;
import com.jean.accountmanager.manager.infra.postgresql.AccountRepositoryPostgreSQL;
import com.jean.accountmanager.manager.infra.postgresql.TransactionRepositoryPostgreSQL;
import com.jean.accountmanager.manager.infra.postgresql.entity.AccountEntity;
import com.jean.accountmanager.manager.infra.postgresql.entity.TransactionEntity;
import com.jean.accountmanager.manager.infra.postgresql.mapper.AccountEntityMapper;
import com.jean.accountmanager.manager.infra.postgresql.mapper.TransactionEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionRepositoryImpl implements TransactionRepository {

    TransactionRepositoryPostgreSQL transactionRepository;
    TransactionEntityMapper transactionEntityMapper;
    @Override
    public Transaction createTransaction(Transaction transaction) {

        TransactionEntity newTransaction = transactionRepository.save(transactionEntityMapper.toEntity(transaction));
        return transactionEntityMapper.toDomain(newTransaction);
    }
}

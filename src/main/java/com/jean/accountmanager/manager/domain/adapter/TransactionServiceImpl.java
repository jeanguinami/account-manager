package com.jean.accountmanager.manager.domain.adapter;

import com.jean.accountmanager.manager.domain.model.Transaction;
import com.jean.accountmanager.manager.domain.port.repository.TransactionRepository;
import com.jean.accountmanager.manager.domain.port.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.createTransaction(transaction);
    }
}

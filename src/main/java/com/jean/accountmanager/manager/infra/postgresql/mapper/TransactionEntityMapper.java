package com.jean.accountmanager.manager.infra.postgresql.mapper;

import com.jean.accountmanager.manager.domain.model.Account;
import com.jean.accountmanager.manager.domain.model.Transaction;
import com.jean.accountmanager.manager.infra.postgresql.entity.AccountEntity;
import com.jean.accountmanager.manager.infra.postgresql.entity.TransactionEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionEntityMapper {

    private final ModelMapper modelMapper;

    public TransactionEntity toEntity(Transaction domain) {
        return modelMapper.map(domain, TransactionEntity.class);
    }

    public Transaction toDomain(TransactionEntity entity) {
        return modelMapper.map(entity, Transaction.class);
    }

}

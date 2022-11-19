package com.jean.accountmanager.manager.infra.repository;

import com.jean.accountmanager.manager.domain.model.Account;
import com.jean.accountmanager.manager.domain.port.repository.AccountRepository;
import com.jean.accountmanager.manager.infra.postgresql.AccountRepositoryPostgreSQL;
import com.jean.accountmanager.manager.infra.postgresql.entity.AccountEntity;
import com.jean.accountmanager.manager.infra.postgresql.mapper.AccountEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccountRepositoryImpl implements AccountRepository {

    AccountRepositoryPostgreSQL accountRepository;
    AccountEntityMapper accountEntityMapper;
    @Override
    public Account createAccount(Account account) {
        AccountEntity newAccount = accountRepository.save(accountEntityMapper.toEntity(account));
        return accountEntityMapper.toDomain(newAccount);
    }
}

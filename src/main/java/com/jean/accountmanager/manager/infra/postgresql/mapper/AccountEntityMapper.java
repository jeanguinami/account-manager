package com.jean.accountmanager.manager.infra.postgresql.mapper;

import com.jean.accountmanager.manager.domain.model.Account;
import com.jean.accountmanager.manager.infra.postgresql.entity.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountEntityMapper {
    private final ModelMapper modelMapper;
    public AccountEntity toEntity(Account domain) {
        return modelMapper.map(domain, AccountEntity.class);
    }

    public Account toDomain(AccountEntity entity) {
        return modelMapper.map(entity, Account.class);
    }
}

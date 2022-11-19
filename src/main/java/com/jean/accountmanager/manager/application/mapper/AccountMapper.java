package com.jean.accountmanager.manager.application.mapper;

import com.jean.accountmanager.manager.application.request.AccountRequest;
import com.jean.accountmanager.manager.application.response.AccountResponse;
import com.jean.accountmanager.manager.domain.model.Account;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountMapper {
    private final ModelMapper modelMapper;

    public AccountResponse toResponse(Account domain) {
        return modelMapper.map(domain, AccountResponse.class);
    }

    public Account toDomain(AccountRequest request) {
        return modelMapper.map(request, Account.class);
    }
}

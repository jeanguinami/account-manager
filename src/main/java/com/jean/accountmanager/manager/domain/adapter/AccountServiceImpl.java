package com.jean.accountmanager.manager.domain.adapter;

import com.jean.accountmanager.manager.domain.model.Account;
import com.jean.accountmanager.manager.domain.port.repository.AccountRepository;
import com.jean.accountmanager.manager.domain.port.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    @Override
    public Account createAccount(Account account) {
        return accountRepository.createAccount(account);
    }

    @Override
    public Account getAccount(Integer accountId) {
        return accountRepository.findAccount(accountId);
    }
}

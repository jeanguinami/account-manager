package com.jean.accountmanager.manager.domain.port.service;

import com.jean.accountmanager.manager.domain.model.Account;

public interface AccountService {
    Account createAccount(Account account);

    Account getAccount(Integer accountId);
}

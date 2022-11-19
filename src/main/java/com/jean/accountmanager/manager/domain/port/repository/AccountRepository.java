package com.jean.accountmanager.manager.domain.port.repository;

import com.jean.accountmanager.manager.domain.model.Account;

public interface AccountRepository {
    Account createAccount(Account account);

    Account findAccount(Integer accountId);
}

package com.jean.accountmanager.manager.infra.postgresql;

import com.jean.accountmanager.manager.infra.postgresql.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepositoryPostgreSQL extends CrudRepository<AccountEntity, Long> {

    AccountEntity findById(Integer id);
}

package com.jean.accountmanager.manager.infra.postgresql;

import com.jean.accountmanager.manager.infra.postgresql.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepositoryPostgreSQL extends CrudRepository<TransactionEntity, Long> {
}

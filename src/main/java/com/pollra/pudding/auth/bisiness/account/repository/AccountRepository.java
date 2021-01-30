package com.pollra.pudding.auth.bisiness.account.repository;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByIdentity(String identity);
}

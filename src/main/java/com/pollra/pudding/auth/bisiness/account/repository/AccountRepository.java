package com.pollra.pudding.auth.bisiness.account.repository;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByIdentity(String identity);

    @Modifying(clearAutomatically=true)
    @Query("UPDATE Account a SET a.nickname = ?2 WHERE a.id = ?1")
    int modifiedNickname(Long id, String nickname);

    Account findAccountByIdAndPassword(Long id, String password);
}

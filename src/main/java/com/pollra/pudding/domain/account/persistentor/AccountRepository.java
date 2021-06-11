package com.pollra.pudding.domain.account.persistentor;

import com.pollra.pudding.domain.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description AccountRepository
 **********************************************************************************************************************/
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}

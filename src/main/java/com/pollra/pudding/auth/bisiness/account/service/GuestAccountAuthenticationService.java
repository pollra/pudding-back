package com.pollra.pudding.auth.bisiness.account.service;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import com.pollra.pudding.auth.bisiness.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author pollra
 * @description GuestValidationService
 * @since 2021.01.31
 **********************************************************************************************************************/
@Slf4j
@Service
@RequiredArgsConstructor
public class GuestAccountAuthenticationService {

    private final AccountRepository accountRepository;

    public boolean guestAccountPasswordCheck(Account entity){
        Account account = accountRepository.findAccountByIdAndPassword(entity.getId(), entity.getPassword());
        return account != null;
    }

    public boolean guestAccountIdentityCheck(Account entity) {
        Account account = accountRepository.findById(entity.getId()).orElse(null);
        return account != null;
    }
}

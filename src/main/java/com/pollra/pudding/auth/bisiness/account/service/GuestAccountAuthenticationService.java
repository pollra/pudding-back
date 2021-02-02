package com.pollra.pudding.auth.bisiness.account.service;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import com.pollra.pudding.auth.bisiness.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Account> account = accountRepository.findById(entity.getId());
        if(ObjectUtils.isEmpty(account.orElse(null)))
            throw new RuntimeException("계정이 존재하지 않습니다.");
        log.info("entity.password["+entity.getPassword()+"] == db.password["+account.get().getPassword()+"]");
        if(entity.getPassword().equals(account.get().getPassword()))
            return true;
        throw new RuntimeException("비밀번호가 일치하지 않습니다.");
    }
}

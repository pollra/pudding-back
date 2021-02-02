package com.pollra.pudding.auth.bisiness.account.service;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import com.pollra.pudding.auth.bisiness.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @since       2021.01.31
 * @author      pollra
 * @description GuestAccountService
 **********************************************************************************************************************/
@Slf4j
@Service
@RequiredArgsConstructor
public class GuestAccountService {

    private final AccountRepository accountRepository;

    public Account findOne(Account entity) {
        return accountRepository.findById(entity.getId())
                .orElse(Account.builder()
                        .identity("0.0.0.0")
                        .nickname("Guest")
                        .build());
    }

    public Account add(Account entity) {
        return accountRepository.save(entity);
    }

    @Transactional
    public int modifiedNickname(Account entity) {
        return accountRepository.modifiedNickname(entity.getId(), entity.getNickname());
    }
}

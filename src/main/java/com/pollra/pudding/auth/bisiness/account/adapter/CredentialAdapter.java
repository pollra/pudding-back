package com.pollra.pudding.auth.bisiness.account.adapter;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import com.pollra.pudding.auth.bisiness.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.pollra.pudding.auth.bisiness.account.mapper.AccountMapper.mapper;

/**
 * @author pollra
 * @description CredentialAdapter
 * @since 2021.02.28
 **********************************************************************************************************************/
@Slf4j
@Component
@RequiredArgsConstructor
public class CredentialAdapter {
    private final AccountService accountService;

    public Account authentication(Account account) {
        return accountService.authentication(account);
    }

    public Account authorization(Account account) {
        return accountService.authorization(account);
    }
}

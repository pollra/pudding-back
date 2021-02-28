package com.pollra.pudding.auth.bisiness.account.adapter;

import com.pollra.pudding.auth.bisiness.account.service.AccountService;
import com.pollra.pudding.common.engine.filter.jwt.domain.Credential;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.pollra.pudding.auth.bisiness.account.mapper.AccountMapper.mapper;

/**
 * @author pollra
 * @description CredentialAdapter
 * @since 2021.02.28
 **********************************************************************************************************************/
@Slf4j
@RequiredArgsConstructor
public class CredentialAdapter {
    private final AccountService accountService;

    public Credential authentication(Credential credential) {
        return mapper.toCredential(accountService.authentication(mapper.toAccount(credential)));
    }

    public Credential authorization(Credential credential) {
        return mapper.toCredential(accountService.authorization(mapper.toAccount(credential)));
    }
}

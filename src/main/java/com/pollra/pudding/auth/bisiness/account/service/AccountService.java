package com.pollra.pudding.auth.bisiness.account.service;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import com.pollra.pudding.auth.bisiness.account.repository.AccountRepository;
import com.pollra.pudding.common.base.annotation.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Description("인증")
    @Transactional(readOnly = true)
    public Account authentication(Account entity) {
        return accountRepository.findAccountByNickname(entity.getNickname());
    }

    @Description("인가")
    public Account authorization(Account entity) {
        return accountRepository.save(entity);
    }
}

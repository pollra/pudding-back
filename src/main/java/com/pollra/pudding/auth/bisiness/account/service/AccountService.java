package com.pollra.pudding.auth.bisiness.account.service;

import com.pollra.pudding.auth.bisiness.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

}

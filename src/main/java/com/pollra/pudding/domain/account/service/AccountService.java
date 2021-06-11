package com.pollra.pudding.domain.account.service;

import com.pollra.pudding.domain.account.entity.Account;
import com.pollra.pudding.domain.account.entity.AccountFactory;
import com.pollra.pudding.domain.account.persistentor.AccountRepository;
import com.pollra.pudding.domain.account.service.command.AccountCommand.Request;
import com.pollra.pudding.domain.account.service.command.AccountCommand.Response;
import com.pollra.pudding.domain.role.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description AccountService
 **********************************************************************************************************************/
@Service
@RequiredArgsConstructor
public class AccountService {
	
	private final AccountRepository accountRepository;

}

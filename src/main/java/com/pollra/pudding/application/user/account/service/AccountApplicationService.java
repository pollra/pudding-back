package com.pollra.pudding.application.user.account.service;

import com.pollra.pudding.domain.account.service.AccountService;
import com.pollra.pudding.domain.account.service.command.AccountCommand;
import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.domain.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description AccountApplicationService
 **********************************************************************************************************************/
@Service
@RequiredArgsConstructor
public class AccountApplicationService {
	
	private final AccountService accountService;
	private final RoleService roleService;
	
	@Transactional
	public AccountCommand.Response.Create create(AccountCommand.Request.Create account) {
		return null;
	}
}

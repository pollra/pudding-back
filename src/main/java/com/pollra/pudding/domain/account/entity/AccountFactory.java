package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.domain.account.service.command.AccountCommand;
import com.pollra.pudding.domain.role.entity.Role;

import java.util.Objects;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description AccountFactory
 **********************************************************************************************************************/
public class AccountFactory {
	public static Account create(AccountCommand.Request.Create create, Role role) {
		if(Objects.isNull(create) || Objects.isNull(role))
			throw new IllegalStateException("account 는 null 이 될 수 없습니다.");
		return new Account(new AccountIdentity(create.getIdentity())
						  ,new AccountNickname(create.getNickname())
						  ,new AccountPassword(create.getPassword(), create.getPasswordCheck())
						  ,role);
	}
}

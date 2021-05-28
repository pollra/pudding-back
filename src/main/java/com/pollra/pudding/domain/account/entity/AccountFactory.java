package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.domain.account.service.command.AccountCommand;
import com.pollra.pudding.domain.role.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description AccountFactory
 **********************************************************************************************************************/
public class AccountFactory {
	public static Account create(AccountCommand.Request.Create create, Role role) {
		return new Account(new AccountIdentity(create.getIdentity())
						  ,new AccountNickname(create.getNickname())
						  ,new AccountPassword(create.getPassword(), create.getPasswordCheck())
						  ,role);
	}

	public static AccountCommand.Response.Create toCreateCommand(Account entity) {
		return AccountCommand.Response.Create.builder()
				.id(entity.getId())
				.identity(entity.getIdentity().getIdentity())
				.nickname(entity.getNickname().getNickname())
				.build();
	}
}

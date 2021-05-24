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
@Mapper(unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface AccountFactory {
	AccountFactory accountFactory = Mappers.getMapper(AccountFactory.class);
	
	AccountCommand.Response.Create toResponseCreate(Account account);

	default Account newAccount(AccountCommand.Request.Create create, Role role) {
		return new Account(new AccountIdentity(create.getIdentity())
						  ,new AccountNickname(create.getNickname())
						  ,new AccountPassword(create.getPassword(), create.getPasswordCheck())
						  ,role);
	}
}

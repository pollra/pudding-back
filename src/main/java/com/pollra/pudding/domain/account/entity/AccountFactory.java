package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.domain.role.entity.RoleFactory;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description AccountFactory
 **********************************************************************************************************************/
public class AccountFactory {
	public static Account createNomalAccount(final String identity, final String nickname, String password) {
		return new Account(identity, nickname, password, RoleFactory.createGuestRole());
	}
}

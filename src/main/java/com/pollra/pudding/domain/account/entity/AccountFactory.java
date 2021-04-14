package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.common.engine.constant.Constant;
import com.pollra.pudding.domain.role.entity.RoleFactory;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description AccountFactory
 **********************************************************************************************************************/
public class AccountFactory {
	public static Account createNormalAccount(final String identity, final String nickname, String password) {
		return new Account(identity, nickname, password, RoleFactory.createGuestRole(Constant.String.EMPTY));
	}
}

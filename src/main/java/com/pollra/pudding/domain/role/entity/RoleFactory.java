package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.domain.role.enumerated.AuthorityCode;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description RoleFactory
 **********************************************************************************************************************/
public class RoleFactory {
	public static Role createGuestRole() {
		return new Role(null, AuthorityCode.GUEST);
	}
}

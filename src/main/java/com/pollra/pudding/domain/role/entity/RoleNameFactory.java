package com.pollra.pudding.domain.role.entity;

import static com.pollra.pudding.domain.acl.enumerated.AuthorityCode.*;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description RoleNameFactory
 **********************************************************************************************************************/
public class RoleNameFactory {
	
	public static RoleName guestRoleName() {
		return new RoleName(GUEST);
	}
	
	public static RoleName createNewGuestRoleName(String name) {
		return new RoleName(name, GUEST);
	}
	
	public static RoleName createNewVisitorRoleName(String name) {
		return new RoleName(name, VISITOR);
	}
	
	public static RoleName createNewMemberRoleName(String name) {
		return new RoleName(name, MEMBER);
	}
	
	public static RoleName createNewMasterRoleName(String name) {
		return new RoleName(name, MASTER);
	}
	
	public static RoleName createNewAdminRoleName(String name) {
		return new RoleName(name, ADMIN);
	}
}

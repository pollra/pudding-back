package com.pollra.pudding.domain.role.entity;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description RoleFactory
 **********************************************************************************************************************/
public class RoleFactory {
	
	public static Role guestRole() {
		return new Role();
	}
	
	public static Role createGuestRole(final String name) {
		return new Role(RoleNameFactory.createNewGuestRoleName(name));
	}
	
	public static Role createVisitorRole(final String name) {
		return new Role(RoleNameFactory.createNewVisitorRoleName(name));
	}
	
	public static Role createMemberRole(final String name) {
		return new Role(RoleNameFactory.createNewMemberRoleName(name));
	}
	
	public static Role createMasterRole(final String name) {
		return new Role(RoleNameFactory.createNewMasterRoleName(name));
	}
	
	public static Role createAdminRole(final String name) {
		return new Role(RoleNameFactory.createNewAdminRoleName(name));
	}
}

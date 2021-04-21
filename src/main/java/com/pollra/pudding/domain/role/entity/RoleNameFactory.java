package com.pollra.pudding.domain.role.entity;

import static com.pollra.pudding.domain.acl.enumerated.AuthorityCode.GUEST;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description RoleNameFactory
 **********************************************************************************************************************/
public class RoleNameFactory {
	public static RoleName guestRoleName(){
		return new RoleName("", GUEST);
	}
	
	public static RoleName createNewGuestRoleName(String name){
		return new RoleName(name, GUEST);
	} // TODO: 팩토리가 너무 쉽게 쓰이고있다 기준이 필요함
}

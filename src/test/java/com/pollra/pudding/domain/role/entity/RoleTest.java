package com.pollra.pudding.domain.role.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Role 엔티티 테스트")
class RoleTest {
	@Test
	@DisplayName("권한 생성 시 이름이 2자 미만인 경우 예외 발생")
	public void throwsException1() {
		assertThrows(IllegalArgumentException.class,
				()-> RoleFactory.createGuestRole("0"));
	}
	
	@Test
	@DisplayName("권한 생성 시 이름이 20자를 초과하는 경우 예외 발생")
	public void throwsException2() {
		assertThrows(IllegalArgumentException.class,
				()-> RoleFactory.createGuestRole("012345678901234567890"));
	}
	
	@Test
	@DisplayName("GUEST 권한 생성")
	public void createGuest(){
		RoleFactory.createGuestRole("test");
	}
	
	@Test
	@DisplayName("VISITOR 권한 생성")
	public void createVisitor(){
		RoleFactory.createGuestRole("test");
	}
	
	@Test
	@DisplayName("MEMBER 권한 생성")
	public void createMember(){
		RoleFactory.createGuestRole("test");
	}
	
	@Test
	@DisplayName("MASTER 권한 생성")
	public void createMaster(){
		RoleFactory.createGuestRole("test");
	}
	
	@Test
	@DisplayName("ADMIN 권한 생성")
	public void createAdmin(){
		RoleFactory.createGuestRole("test");
	}
}
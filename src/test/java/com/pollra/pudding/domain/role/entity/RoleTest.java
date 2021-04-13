package com.pollra.pudding.domain.role.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Role 엔티티 테스트")
class RoleTest {
	@Test
	@DisplayName("GUEST 권한 생성")
	public void createGuest(){
		RoleFactory.createGuestRole();
	}
}
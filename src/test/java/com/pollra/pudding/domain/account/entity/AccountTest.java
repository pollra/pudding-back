package com.pollra.pudding.domain.account.entity;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Account 엔티티 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountTest {
	
	@Test
	@Order(1)
	@DisplayName("아이디가 4자 미만인 경우 예외발생")
	public void idIsLessThan4Characters(){
		assertThrows(IllegalArgumentException.class
				, () -> AccountFactory.createNormalAccount("1", "0123456789", "0123456789"));
	}
	
	@Test
	@Order(2)
	@DisplayName("아이디가 20자를 초과하는 경우 예외발생")
	public void idIsMoreThan20Characters(){
		assertThrows(IllegalArgumentException.class
				, ()-> AccountFactory.createNormalAccount("012345678901234567890", "0123456789", "0123456789"));
	}
	
	@Test
	@Order(3)
	@DisplayName("닉네임이 2자 미만인 경우 예외발생")
	public void anErrorOccursWhenTheNicknameIsLessThan8Characters() {
		assertThrows(IllegalArgumentException.class
				, ()-> AccountFactory.createNormalAccount("0123456789", "0", "0123456789"));
	}
	
	@Test
	@Order(4)
	@DisplayName("닉네임이 12자를 초과하는 경우 예외발생")
	public void anErrorOccursWhenTheNicknameIsMoreThan12Characters() {
		assertThrows(IllegalArgumentException.class
				, ()-> AccountFactory.createNormalAccount("0123456789", "0123456789012", "0123456789"));
	}
	
	@Test
	@Order(5)
	@DisplayName("비밀번호가 8자 미만인 경우 예외발생")
	public void anErrorOccursWhenThePasswordIsLessThan8Characters() {
		assertThrows(IllegalArgumentException.class
				, ()-> AccountFactory.createNormalAccount("0123456789", "0", "0123456789"));
	}
	
	@Test
	@Order(6)
	@DisplayName("비밀번호가 20자를 초과하는 경우 예외발생")
	public void anErrorOccursWhenTheNicknameIsMoreThan20Characters() {
		assertThrows(IllegalArgumentException.class
				, ()-> AccountFactory.createNormalAccount("0123456789", "0123456789012", "0123456789"));
	}
	
	@Test
	@Order(7)
	@DisplayName("값이 모두 정상일 경우 예외를 발생하지 않음")
	public void createComplete() {
		AccountFactory.createNormalAccount("0123456789", "012345678901", "0123456789");
	}
}
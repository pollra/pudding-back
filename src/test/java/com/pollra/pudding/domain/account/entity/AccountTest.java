package com.pollra.pudding.domain.account.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Account 엔티티 테스트")
class AccountTest {
	
	@Test
	@DisplayName("아이디가 4자 미만인 경우 에러발생")
	public void idIsLessThan4Characters(){
		assertThrows(IllegalArgumentException.class
				, () -> AccountFactory.createNomalAccount("1", "0123456789", "0123456789"));
	}
	
	@Test
	@DisplayName("아이디가 20자를 초과하는 경우 에러발생")
	public void idIsMoreThan20Characters(){
		assertThrows(IllegalArgumentException.class
				, ()-> AccountFactory.createNomalAccount("012345678901234567890", "0123456789", "0123456789"));
	}
	
	@Test
	@DisplayName("닉네임이 8자 미만인 경우 에러발생")
	public void anErrorOccursWhenTheNicknameIsLessThan8Characters() {
		assertThrows(IllegalArgumentException.class
				, ()-> AccountFactory.createNomalAccount("0123456789", "0", "0123456789"));
	}
	
	@Test
	@DisplayName("닉네임이 12자를 초과하는 경우 에러발생")
	public void anErrorOccursWhenTheNicknameIsMoreThan12Characters() {
		assertThrows(IllegalArgumentException.class
				, ()-> AccountFactory.createNomalAccount("0123456789", "0123456789012", "0123456789"));
	}
	
	@Test
	@DisplayName("값이 모두 정상일 경우 예외를 발생하지 않음")
	public void createComplete() {
		AccountFactory.createNomalAccount("0123456789", "012345678901", "0123456789");
	}
}
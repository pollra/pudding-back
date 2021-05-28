package com.pollra.pudding.domain.account.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[VO]AccountNickname 테스트")
class AccountNicknameTest {

    @Nested
    @DisplayName("닉네임을 잘못 요청했을 때")
    class exceptions {

        @Test
        @DisplayName("2자 미만이면 예외 발생")
        public void lessThen2() {
            assertThrows(IllegalArgumentException.class,
                    ()-> new AccountNickname("0"));
        }

        @Test
        @DisplayName("12자를 초과하면 예외 발생")
        public void moreThen12() {
            assertThrows(IllegalArgumentException.class,
                    () -> new AccountNickname("0123456789012"));
        }
    }

    @Nested
    @DisplayName("정상적인 생성 요청일 때")
    class Ok {

        @Test
        @DisplayName("2자 인 경우 정상 동작")
        public void orMore2() {
            assertDoesNotThrow(
                    () -> new AccountNickname("01"));
        }

        @Test
        @DisplayName("12자 인 경우 정상 동작")
        public void orLess12() {
            assertDoesNotThrow(
                    () -> new AccountNickname("012345678901"));
        }
    }
}
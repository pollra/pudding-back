package com.pollra.pudding.domain.account.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[VO]AccountPassword 테스트")
class AccountPasswordTest {

    @Nested
    @DisplayName("비밀번호가 정상적으로 입력되었을 때")
    class Ok {
        @Test
        @DisplayName("8자 이면 정상 동작")
        public void orMore8() {
            assertDoesNotThrow(() ->new AccountPassword("01234567", "01234567"));
        }

        @Test
        @DisplayName("30자 이면 정상 동작")
        public void orLess30() {
            assertDoesNotThrow(()-> new AccountPassword("01234567890123456789", "01234567890123456789"));
        }
    }

    @Nested
    @DisplayName("비밀번호를 잘못 입력했을 때")
    class Exceptions {

        @Test
        @DisplayName("8 미만인 경우 예외 발생")
        public void lessThen8() {
            assertThrows(IllegalArgumentException.class,
                    () -> new AccountPassword("0123456", "0123456"));
        }

        @Test
        @DisplayName("30 초과인 경우 예외 발생")
        public void moreLess30() {
            assertThrows(IllegalArgumentException.class,
                    () -> new AccountPassword("0123456789012345678901234567890", "0123456789012345678901234567890"));
        }

        @Test
        @DisplayName("passwordCheck 와 일치하지 않는 경우 예외 발생")
        public void notEquals() {
            assertThrows(IllegalArgumentException.class,
                    () -> new AccountPassword("0123456789", "01234567890123456789"));
        }
    }
}
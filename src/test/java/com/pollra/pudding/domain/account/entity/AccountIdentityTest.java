package com.pollra.pudding.domain.account.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[VO]AccountIdentity 테스트")
public class AccountIdentityTest {

    @Nested
    @DisplayName("아이디를 잘못 입력했을때")
    class IdentityExceptionTest {
        @Test
        @DisplayName("20자 초과인 경우 예외 발생")
        public void moreThen20(){
            assertThrows(IllegalArgumentException.class,
                    () -> new AccountIdentity("012345678901234567890"));
        }

        @Test
        @DisplayName("4자 미만인 경우 예외 발생")
        public void lessThen4() {
            assertThrows(IllegalArgumentException.class,
                    ()-> new AccountIdentity("012"));
        }
    }

    @Nested
    @DisplayName("아이디가 정상적으로 입력되었을 때")
    class Ok {
        @Test
        @DisplayName("4자 이상이면 정상 동작")
        public void orMore4(){
            assertDoesNotThrow(
                    () -> new AccountIdentity("0123"));
        }

        @Test
        @DisplayName("20자 이하면 정상동작")
        public void orLess20() {
            assertDoesNotThrow(
                    () -> new AccountIdentity("01234567890123456789"));
        }
    }

    @Nested
    @DisplayName("인수로 아무 데이터도 넘기지 않을 때")
    class NoArgument {

        @Test
        @DisplayName("정상 동작")
        public void ok() {
            assertDoesNotThrow(() -> new AccountIdentity());
        }
    }

}

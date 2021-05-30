package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.domain.acl.enumerated.AuthorityCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("[VO]RoleName 테스트")
public class RoleNameTest {

    @Nested
    @DisplayName("권한 이름이 정상적인 경우")
    class Ok {

        @Test
        @DisplayName("입력된 값이 2자 이면 정상 동작")
        public void more() {
            assertDoesNotThrow(
                    () -> RoleName.createCustomRole("01", AuthorityCode.GUEST)
            );
        }

        @Test
        @DisplayName("입력된 값이 20자 이면 정상동작")
        public void runner() {
            assertDoesNotThrow(
                    ()-> RoleName.createCustomRole("01234567890123456789", AuthorityCode.GUEST)
            );
        }
    }

    @Nested
    @DisplayName("권한 요청에 실패했을 때")
    class exceptions {

        @Test
        @DisplayName("입력된 값이 2 미만이면 예외 발생")
        public void lessThen() {
            assertThrows(IllegalArgumentException.class,
                    () -> RoleName.createCustomRole("0", AuthorityCode.GUEST));
        }

        @Test
        @DisplayName("입력된 값이 20을 초과하면 예외 발생")
        public void moreThen() {
            assertThrows(IllegalArgumentException.class,
                    () -> RoleName.createCustomRole("012345678901234567890", AuthorityCode.GUEST));
        }
    }
}

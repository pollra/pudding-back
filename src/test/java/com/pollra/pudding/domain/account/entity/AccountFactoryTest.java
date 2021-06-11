package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.domain.account.service.command.AccountCommand;
import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.domain.role.entity.RoleFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountFactoryTest {

    @Test
    @DisplayName("매개변수 없는 생성자 테스트")
    public void noArgument () {
        assertNotNull(new AccountFactory());
    }

    @Nested
    @DisplayName("생성 함수 호출")
    public class Constructor {

        @Test
        @DisplayName("인자가 모두 정상적인 경우 정상 동작")
        public void ok () {
            AccountFactory accountFactory = new AccountFactory();

            Role role = RoleFactory.guestRole();

            Account account = accountFactory.create(
                    AccountCommand.Request.Create.builder()
                            .identity("0123456789")
                            .nickname("0123456789")
                            .password("0123456789")
                            .passwordCheck("0123456789")
                            .build(),
                    role
            );

            assertNotNull(account);
        }

        @Test
        @DisplayName("인자가 모두 Null 일 경우 에러 발생")
        public void fail() {
            assertThrows(IllegalStateException.class,
                    ()-> AccountFactory.create(null, null));
        }

        @Test
        @DisplayName("인자 하나라도 Null 일 경우 에러 발생")
        public void fail_oneArgumentIsNull() {
            AccountCommand.Request.Create accountCommand = AccountCommand.Request.Create.builder()
                    .identity("0123456789")
                    .nickname("0123456789")
                    .password("0123456789")
                    .passwordCheck("0123456789")
                    .build();

            assertAll(
                    () -> assertThrows(IllegalStateException.class,
                            () -> AccountFactory.create(null, RoleFactory.guestRole())),
                    () -> assertThrows(IllegalStateException.class,
                            () -> AccountFactory.create(accountCommand, null))
            );
        }

        @Nested
        @DisplayName("command 객체의 값이 비정상적일 때")
        public class CommandObject {

            @Test
            @DisplayName("AccountIdentity 가 null일 때 예외 발생")
            public void commandObjectIdentityIsNull() {
                AccountCommand.Request.Create accountCommand = AccountCommand.Request.Create.builder()
                        .identity(null)
                        .nickname("0123456789")
                        .password("0123456789")
                        .passwordCheck("0123456789")
                        .build();
                assertThrows(NullPointerException.class,
                        () -> AccountFactory.create(accountCommand, RoleFactory.guestRole()));
            }
        }
    }
}
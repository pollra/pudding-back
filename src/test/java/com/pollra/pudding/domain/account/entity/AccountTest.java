package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.domain.account.service.command.AccountCommand;
import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.domain.role.entity.RoleFactory;
import com.pollra.pudding.domain.role.repository.RoleRepository;
import com.pollra.pudding.domain.role.service.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[Entity]Account 테스트")
public class AccountTest {

    @Nested
    @DisplayName("데이터가 정상적으로 들어왔을 때")
    class Ok {

        @Test
        @DisplayName("Role 이 정상적으로 입력되었을 경우 정상 동작")
        public void notNull(){
            Role role = RoleFactory.guestRole();

            Account account = AccountFactory.create(
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
    }

    @Nested
    @DisplayName("데이터가 잘못 들어왔을 때")
    class Exceptions {

        @Test
        @DisplayName("Role 이 들어오지 않을 경우 예외 발생")
        public void isNull() {
            Role role = null;

            assertThrows(IllegalStateException.class,
                    ()->AccountFactory.create(
                    AccountCommand.Request.Create.builder()
                            .identity("0123456789")
                            .nickname("0123456789")
                            .password("0123456789")
                            .passwordCheck("0123456789")
                            .build(),
                    role)
            );
        }
    }
}

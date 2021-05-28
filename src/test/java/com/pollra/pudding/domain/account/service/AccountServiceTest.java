package com.pollra.pudding.domain.account.service;

import com.pollra.pudding.domain.account.entity.Account;
import com.pollra.pudding.domain.account.entity.AccountFactory;
import com.pollra.pudding.domain.account.repository.AccountRepository;
import com.pollra.pudding.domain.account.service.command.AccountCommand;
import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.domain.role.entity.RoleFactory;
import com.pollra.pudding.domain.role.repository.RoleRepository;
import com.pollra.pudding.domain.role.service.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("[DomainService]AccountService 테스트")
public class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    @Mock
    RoleRepository roleRepository;

    AccountService accountService;

    RoleService roleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        roleService    = new RoleService(roleRepository);
        accountService = new AccountService(accountRepository);
    }

    @Test
    @DisplayName("계정 생성이 정상적으로 이루어지는 경우 정상 동작")
    public void ok() {
        AccountCommand.Request.Create build = AccountCommand.Request.Create.builder()
                .identity("0123456789")
                .nickname("0123456789")
                .password("0123456789")
                .passwordCheck("0123456789")
                .build();

        Role role = RoleFactory.guestRole();

        when(roleRepository.findByRoleName(any(Role.class))).thenReturn(role);
        Role guestRole = roleService.getGuestRole();

        Account accountServiceResult = AccountFactory.create(build, guestRole);
        when(accountRepository.save(any(Account.class))).thenReturn(accountServiceResult);
        AccountCommand.Response.Create account = accountService.createAccount(build, guestRole);

        assertNotNull(account);
    }
}

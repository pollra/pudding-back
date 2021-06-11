package com.pollra.pudding.domain.account.service;

import com.pollra.pudding.domain.account.persistentor.AccountRepository;
import com.pollra.pudding.domain.role.persistentor.RoleRepository;
import com.pollra.pudding.domain.role.service.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
}

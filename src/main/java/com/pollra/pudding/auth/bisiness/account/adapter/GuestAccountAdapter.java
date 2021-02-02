package com.pollra.pudding.auth.bisiness.account.adapter;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import com.pollra.pudding.auth.bisiness.account.service.GuestAccountAuthenticationService;
import com.pollra.pudding.auth.bisiness.account.service.GuestAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pollra
 * @description GuestAccountAdapter
 * @since 2021.02.01
 **********************************************************************************************************************/
@Slf4j
@Component
@RequiredArgsConstructor
public class GuestAccountAdapter {
    private final GuestAccountService guestAccountService;
    private final GuestAccountAuthenticationService guestAccountAuthenticationService;

    public int changeNickname(Account entity) {
        boolean isAccountPasswordMatch = guestAccountAuthenticationService.guestAccountPasswordCheck(entity);
        if(isAccountPasswordMatch)
            return guestAccountService.modifiedNickname(entity);
        throw new RuntimeException("닉네임 변경에 실패하였습니다.");
    }
}

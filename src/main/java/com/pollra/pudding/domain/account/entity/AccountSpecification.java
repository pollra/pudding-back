package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.domain.role.entity.Role;

import java.util.Objects;

import static com.pollra.pudding.common.engine.util.StringScopeUtil.notBetweenIs;

/**
 * @since       2021.06.09
 * @author      pollra
 * @description account specification
 **********************************************************************************************************************/
public class AccountSpecification {

    public static boolean isValid(Account account){
        return isValid(account.getRole()    ) &&
               isValid(account.getIdentity()) &&
               isValid(account.getNickname()) &&
               isValid(account.getPassword()) ;
    }

    public static boolean isValid(AccountIdentity identity) {
        return isValidIdentity(identity.getIdentity());
    }

    public static boolean isValid(Role role) {
        if( Objects.isNull(role) ) throw new IllegalArgumentException("권한 정보는 Null 일 수 없습니다.");
        return true;
    }

    private static boolean isValidIdentity(String identity) {
        if( notBetweenIs(identity, 4, 20) )
            throw new IllegalArgumentException("아이디를 다시 확인 해 주세요.");
        return true;
    }

    public static boolean isValid(AccountNickname nickname) {
        return isValidNickname(nickname.getNickname());
    }

    public static boolean isValidNickname(String nickname) {
        if(notBetweenIs(nickname, 2, 12))
            throw new IllegalArgumentException("닉네임을 다시 확인 해 주세요.");
        return true;
    }

    public static boolean isValid(AccountPassword password) {
        return isValidPassword(password.getPassword(), password.getPasswordCheck());
    }

    public static boolean isValidPassword(final String password, final String passwordCheck) {
        if( ! password.equals(passwordCheck))
            throw new IllegalArgumentException("비밀번호 확인이 일치하지 않습니다.");
        if(notBetweenIs(password, 8, 30))
            throw new IllegalArgumentException("비밀번호를 다시 확인 해 주세요.");
        return true;
    }
}

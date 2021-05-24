package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.common.engine.encrypt.sha.converter.OneWayEncryptionConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

import static com.pollra.pudding.common.engine.util.StringScopeUtil.betweenIs;

@Embeddable
@Getter
@NoArgsConstructor
public class AccountPassword {

    @Column(nullable=false)
    @Convert(converter= OneWayEncryptionConverter.class)
    private String password;

    protected AccountPassword(final String password, final String passwordCheck) {
        if( ! password.equals(passwordCheck)) {
            throw new IllegalArgumentException("비밀번호 확인이 일치하지 않습니다.");
        }
        if(betweenIs(password, 8, 30)) {
            throw new IllegalArgumentException("비밀번호를 다시 확인 해 주세요.");
        }
        this.password = password;
    }
}

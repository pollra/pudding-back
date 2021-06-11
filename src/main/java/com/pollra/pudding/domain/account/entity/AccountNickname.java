package com.pollra.pudding.domain.account.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static com.pollra.pudding.common.engine.util.StringScopeUtil.notBetweenIs;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountNickname {

    @Getter
    @Column(nullable=false, unique=true)
    private String nickname;

    protected AccountNickname(final String nickname) {
        this.nickname = nickname;
        AccountSpecification.isValid(this);
    }
}

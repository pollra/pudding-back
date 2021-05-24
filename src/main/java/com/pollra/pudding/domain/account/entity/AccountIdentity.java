package com.pollra.pudding.domain.account.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static com.pollra.pudding.common.engine.util.StringScopeUtil.betweenIs;

@Embeddable
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class AccountIdentity {

    @Column(nullable=false, unique=true, length = 20)
    private String identity;

    protected AccountIdentity(final String identity) {
        if(betweenIs(identity, 4, 20)) {
            throw new IllegalArgumentException("아이디를 다시 확인 해 주세요.");
        }
        this.identity = identity;
    }
}

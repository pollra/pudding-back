package com.pollra.pudding.domain.account.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static com.pollra.pudding.common.engine.util.StringScopeUtil.betweenIs;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountNickname {

    @Column(nullable=false, unique=true)
    private String nickname;

    protected AccountNickname(String nickname) {
        if(betweenIs(nickname, 2, 12)) {
            throw new IllegalArgumentException("닉네임을 다시 확인 해 주세요.");
        }
        this.nickname = nickname;
    }
}

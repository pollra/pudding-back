package com.pollra.pudding.domain.account.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class AccountIdentity {

    @Getter
    @Column(nullable=false, unique=true, length = 20)
    private String identity;

    protected AccountIdentity(final String identity) {
        this.identity = identity;
        AccountSpecification.isValid(this);
    }
}

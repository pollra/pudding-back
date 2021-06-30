package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.infra.engine.encrypt.sha.converter.OneWayEncryptionConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * @since   2021.06.11
 * @author  pollra
 * @apiNote Account 의 Password 를 관리하는 ValueObject
 **********************************************************************************************************************/
@Embeddable
@NoArgsConstructor
public class AccountPassword {

    @Getter
    @Column(nullable=false)
    @Convert(converter= OneWayEncryptionConverter.class)
    private String password;

    @Getter
    @Transient
    private String passwordCheck;

    protected AccountPassword(final String password, final String passwordCheck) {
        this.password = password;
        this.passwordCheck = passwordCheck;
        AccountSpecification.isValid(this);
    }
}

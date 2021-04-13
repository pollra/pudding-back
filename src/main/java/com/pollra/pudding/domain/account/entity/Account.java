package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.common.base.annotation.Description;
import com.pollra.pudding.common.engine.encrypt.sha.converter.OneWayEncryptionConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@EntityListeners(value=OneWayEncryptionConverter.class)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Table(name="ACCOUNT")
public class Account {
    @Id @GeneratedValue
    @Column(name="ACCOUNT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private Role role;

    @Description("아이디(Guest:IP, User:Email)")
    @Column(nullable=false, unique=true)
    private String identity;

    @Column(nullable=false, unique=true)
    private String nickname;

    @Column(nullable=false)
    @Convert(converter=OneWayEncryptionConverter.class)
    private String password;
 
	protected Account(final String identity, final String nickname, final String password, final Role role) {
		if(identity.length() < 4 || identity.length() > 20) {
			throw new IllegalArgumentException("identity 는 4자 이상, 20자 이하로 작성 되어야 합니다");
		}
		if(nickname.length() < 2 || nickname.length() > 12) {
			throw new IllegalArgumentException("nickname 은 2자 이상, 12자 이하로 작성 되어야 합니다");
		}
		if(password.length() < 8 || password.length() > 30) {
			throw new IllegalArgumentException("password 은 8자 이상, 30자 이하로 작성 되어야 합니다");
		}
		this.identity = identity;
		this.nickname = nickname;
		this.password = password;
		this.role 	  = role;
	}
}

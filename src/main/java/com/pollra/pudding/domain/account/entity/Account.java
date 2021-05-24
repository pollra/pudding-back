package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.common.engine.exception.ExceptionCode;
import com.pollra.pudding.domain.account.service.command.AccountCommand;
import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.common.base.annotation.Description;
import com.pollra.pudding.common.engine.encrypt.sha.converter.OneWayEncryptionConverter;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
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
	@Embedded
    private AccountIdentity identity;

	@Embedded
    private AccountNickname nickname;

    @Embedded
    private AccountPassword password;
 
	protected Account(final AccountIdentity identity
			         ,final AccountNickname nickname
					 ,final AccountPassword password
					 ,final Role            role) {
		if(Objects.isNull(role)) {
			throw new IllegalStateException("권한은 null 일 수 없습니다.");
		}
		this.identity = identity;
		this.nickname = nickname;
		this.password = password;
		this.role 	  = role;
	}
}

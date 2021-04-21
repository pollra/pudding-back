package com.pollra.pudding.domain.account.entity;

import com.pollra.pudding.common.base.exceptions.IllegalArgumentException;
import com.pollra.pudding.common.engine.exception.ExceptionCode;
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
    @Column(nullable=false, unique=true)
    private String identity;

    @Column(nullable=false, unique=true)
    private String nickname;

    @Column(nullable=false)
    @Convert(converter=OneWayEncryptionConverter.class)
    private String password;
 
	protected Account(final String identity, final String nickname, final String password, final String passwordCheck, final Role role) {
		if(betweenIs(identity, 4, 20)) {
			throw new IllegalArgumentException(ExceptionCode.E00040001, HttpStatus.BAD_REQUEST);
		}
		if(betweenIs(nickname, 2, 12)) {
			throw new IllegalArgumentException(ExceptionCode.E00040002, HttpStatus.BAD_REQUEST);
		}
		if(betweenIs(password, 8, 30)) {
			throw new IllegalArgumentException(ExceptionCode.E00040003, HttpStatus.BAD_REQUEST); // 개선 (세부사항이 도메인에 침투함)
		}
		if(Objects.isNull(role)) {
			throw new IllegalArgumentException(ExceptionCode.E00040004, HttpStatus.BAD_REQUEST); // 사람이 읽을 수 있게 만드는게
		}
		if( ! password.equals(passwordCheck)) {
			throw new IllegalArgumentException(ExceptionCode.E00040005, HttpStatus.BAD_REQUEST);
		}
		this.identity = identity;
		this.nickname = nickname;
		this.password = password;
		this.role 	  = role;
	}
	
	private boolean betweenIs(String target, int min, int max) {
		return target.length() < min || target.length() > max;
	}
}

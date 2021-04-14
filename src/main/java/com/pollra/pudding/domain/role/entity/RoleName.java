package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.domain.acl.enumerated.AuthorityCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description RoleName
 **********************************************************************************************************************/
@Embeddable
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class RoleName {
	
	private String name;
	
	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private AuthorityCode authority;
	
	protected RoleName(final String name, AuthorityCode authority) {
		if(lengthBetweenIs(name, 2, 20) ) {
			throw new IllegalArgumentException("권한 명은 2자 이상 10 자 미만이어야 합니다");
		}
		this.name = name.toUpperCase();
		this.authority = authority;
	}
	
	protected RoleName(AuthorityCode authority) {
		this.authority = authority;
	}
	
	private boolean lengthBetweenIs(final String text, final int min, final int max) {
		return text.length() < min || text.length() > max;
	}
}

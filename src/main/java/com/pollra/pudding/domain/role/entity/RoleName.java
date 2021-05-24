package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.common.engine.exception.ExceptionCode;
import com.pollra.pudding.domain.acl.enumerated.AuthorityCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import javax.persistence.*;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description RoleName
 **********************************************************************************************************************/
@Embeddable
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class RoleName {
	
	@Column(unique=true)
	private String name;
	
	protected RoleName(final String name, AuthorityCode authority) {
		if(StringUtils.isNotBlank(name) && lengthBetweenIs(name, 2, 20) ) {
			throw new IllegalArgumentException(ExceptionCode.E00050001, HttpStatus.BAD_REQUEST);
		}
		this.name = name.toUpperCase()+"_"+authority;
	}
	
	protected RoleName(AuthorityCode authority) {
		this.name = authority.name();
	}
	
	private boolean lengthBetweenIs(final String text, final int min, final int max) {
		return text.length() <= min || text.length() > max;
	}
}

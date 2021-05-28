package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.common.engine.exception.ExceptionCode;
import com.pollra.pudding.domain.acl.enumerated.AuthorityCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import javax.persistence.*;

import static com.pollra.pudding.common.engine.util.StringScopeUtil.betweenIs;

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
	
	private RoleName(final String name, AuthorityCode authority) {
		if(StringUtils.isNotBlank(name) && betweenIs(name, 2, 20) ) {
			throw new IllegalArgumentException("권한 이름을 다시 확인해주세요.");
		}
		this.name = name.toUpperCase()+"_"+authority;
	}
	
	protected RoleName(AuthorityCode authority) {
		this.name = authority.name();
	}

	protected static RoleName createCustomRole(String name, AuthorityCode code) {
		return new RoleName(name, code);
	}
}

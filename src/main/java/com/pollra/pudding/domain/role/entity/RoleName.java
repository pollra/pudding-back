package com.pollra.pudding.domain.role.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import java.util.Objects;

import static com.pollra.pudding.common.engine.util.StringScopeUtil.notBetweenIs;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description RoleName
 **********************************************************************************************************************/
@Embeddable
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class RoleName {

	private String name;

	private AuthorityCode authority;
	
	protected RoleName(final String name, AuthorityCode authority) {
		if(Objects.isNull(name) && notBetweenIs(name, 2, 20) ) {
			throw new IllegalArgumentException("권한 이름을 다시 확인해주세요.");
		}
		this.name = name;
		this.authority = authority;
	}

	protected static RoleName createCustomRole(String name, AuthorityCode code) {
		return new RoleName(name, code);
	}

	public String toString() {
		if(StringUtils.isNotBlank(name)) {
			return name.toUpperCase().concat("_").concat(authority.name());
		} else {
			return authority.name();
		}
	}

	public String authorityName() {
		return authority.name();
	}
}

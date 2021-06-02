package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.common.base.annotation.Description;
import com.pollra.pudding.domain.acl.entity.AclStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pollra
 * @description AuthorityCode
 * @since 2021.02.28
 **********************************************************************************************************************/
@Getter
@AllArgsConstructor
public enum AuthorityCode {
    GUEST	("손님"  ),
	VISITOR	("방문자"),
	MEMBER	("회원"  ),
	MASTER	("주인"  ),
	ADMIN	("관리자");
    
    private String description;
}

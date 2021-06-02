package com.pollra.pudding.domain.acl.entity.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description ResourceCode
 **********************************************************************************************************************/
@Getter
@AllArgsConstructor
public enum ResourceCode {
	PAGE	,
	POST	,
	TAG		,
	CATEGORY,
	COMMENT	;
}

package com.pollra.pudding.domain.acl.entity.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @since       2021.04.14
 * @author      pollra
 * @description ActionCode
 **********************************************************************************************************************/
@Getter
@AllArgsConstructor
public enum ActionCode {
	READ, WRITE, MODIFY, DELETE;
}

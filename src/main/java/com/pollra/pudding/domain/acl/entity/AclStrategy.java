package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.role.entity.AuthorityCode;

import java.util.List;

public interface AclStrategy {
    List<Acl> apply(final AuthorityCode code);
}

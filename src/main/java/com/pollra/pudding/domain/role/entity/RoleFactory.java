package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.domain.acl.enumerated.AuthorityCode;

public class RoleFactory {
    public static Role guestRole() {
        return new Role(new RoleName(AuthorityCode.GUEST));
    }
}

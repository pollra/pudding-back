package com.pollra.pudding.domain.role.entity;

public class RoleFactory {
    public static Role guestRole() {
        return new Role(new RoleName("", AuthorityCode.GUEST));
    }

    public static Role newRole(final String name, final AuthorityCode authorityCode) {
        return new Role(new RoleName(name, authorityCode));
    }
}

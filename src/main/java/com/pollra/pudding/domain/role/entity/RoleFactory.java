package com.pollra.pudding.domain.role.entity;

public class RoleFactory {
    public static Role guestRole() {
        return new Role(new RoleName(AuthorityCode.GUEST));
    }

    public static Role newRole(String name) {
        return null;
    }
}

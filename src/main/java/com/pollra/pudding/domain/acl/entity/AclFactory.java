package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.acl.entity.enumerated.ActionCode;
import com.pollra.pudding.domain.acl.entity.enumerated.ResourceCode;
import com.pollra.pudding.domain.role.entity.Role;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class AclFactory {

    public static List<Acl> createGuestRole(Role role){
        AclBuilder aclBuilder = new AclBuilder(role);
        return Arrays.asList(
                aclBuilder.page().read().build(),
                aclBuilder.post().read().build(),
                aclBuilder.tag().read().build(),
                aclBuilder.category().read().build(),
                aclBuilder.comment().read().build()
        );
    }

    private static List<Acl> createVisitor(Role role) {
        AclBuilder aclBuilder = new AclBuilder(role);
        return Arrays.asList(
                aclBuilder.page().read().build(),
                aclBuilder.post().read().build(),
                aclBuilder.tag().read().build(),
                aclBuilder.category().read().build(),
                aclBuilder.comment().write().build(),
                aclBuilder.comment().delete().build(),
                aclBuilder.comment().modify().build(),
                aclBuilder.comment().read().build()
        );
    }
}

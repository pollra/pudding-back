package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.acl.entity.enumerated.ActionCode;
import com.pollra.pudding.domain.acl.entity.enumerated.ResourceCode;
import com.pollra.pudding.domain.role.entity.Role;
import lombok.AccessLevel;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class AclFactory {

    public static List<Acl> createGuestRole(Role role){
        AclBuilder aclBuilder = new AclBuilder(role);
        LocalDateTime expiration = LocalDateTime.now().plusHours(12);
        return Arrays.asList(
                aclBuilder.page(    1L).read().expirationIs(expiration).build(),
                aclBuilder.category(0L).read().expirationIs(expiration).build(),
                aclBuilder.tag(     1L).read().expirationIs(expiration).build(),
                aclBuilder.post(    0L).read().expirationIs(expiration).build(),
                aclBuilder.comment( 0L).read().expirationIs(expiration).build()
        );
    }

    private static List<Acl> createVisitor(Role role, Long pageId) {
        AclBuilder aclBuilder = new AclBuilder(role);
        LocalDateTime expiration = LocalDateTime.now().plusHours(12);
        return Arrays.asList(
                aclBuilder.page(           pageId).read().expirationIs(expiration).build(),
                aclBuilder.category(0L).read().expirationIs(expiration).build(),
                aclBuilder.tag(     1L).read().expirationIs(expiration).build(),
                aclBuilder.post(    0L).read().expirationIs(expiration).build(),

                aclBuilder.comment(0L).read()  .expirationIs(expiration).build(),
                aclBuilder.comment(0L).write() .expirationIs(expiration).build(),
                aclBuilder.comment(0L).delete().expirationIs(expiration).build(),
                aclBuilder.comment(0L).modify().expirationIs(expiration).build()
        );
    }

    private static List<Acl> createMember(Role role, Long pageId) {
        AclBuilder aclBuilder = new AclBuilder(role);
        LocalDateTime expiration = LocalDateTime.now().plusDays(365);
        return Arrays.asList(
                aclBuilder.page(           pageId).read()  .expirationIs(expiration).build(),
                aclBuilder.category(0L).read()  .expirationIs(expiration).build(),
                aclBuilder.tag(     0L).read()  .expirationIs(expiration).build(),

                aclBuilder.post(    0L).read()  .expirationIs(expiration).build(),
                aclBuilder.post(    0L).write() .expirationIs(expiration).build(),
                aclBuilder.post(    0L).modify().expirationIs(expiration).build(),
                aclBuilder.post(    0L).delete().expirationIs(expiration).build(),

                aclBuilder.comment(0L).write() .expirationIs(expiration).build(),
                aclBuilder.comment(0L).delete().expirationIs(expiration).build(),
                aclBuilder.comment(0L).modify().expirationIs(expiration).build(),
                aclBuilder.comment(0L).read()  .expirationIs(expiration).build()
        );
    }
}

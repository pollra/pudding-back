package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.role.entity.AuthorityCode;
import com.pollra.pudding.domain.role.entity.Role;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.pollra.pudding.common.engine.constant.Constant.Long.*;

public class AclFactory {

    public static List<Acl> defaultRoleSet(final Role role, final Long resourceId) {
        switch( AuthorityCode.valueOf(role.getRoleAuthority()) ) {
            case GUEST:
                return AclFactory.createGuest(role);
            case VISITOR:
                return AclFactory.createVisitor(role, resourceId);
            case MEMBER:
                return AclFactory.createMember(role, resourceId);
            case MASTER:
                return AclFactory.createMaster(role, resourceId);
            case ADMIN:
                return AclFactory.createAdmin(role, resourceId);
            default:
                throw new IllegalArgumentException("존재할 수 없는 권한 생성 요청입니다.");
        }
    }

    private static List<Acl> createGuest(Role role){
        AclBuilder aclBuilder = new AclBuilder(role);
        LocalDateTime expiration = LocalDateTime.now().plusHours(12);
        return Arrays.asList(
                aclBuilder.page(ONE).read().expirationIs(expiration).build(),
                aclBuilder.category(ZERO).read().expirationIs(expiration).build(),
                aclBuilder.tag(ZERO).read().expirationIs(expiration).build(),
                aclBuilder.post(ZERO).read().expirationIs(expiration).build(),
                aclBuilder.comment(ZERO).read().expirationIs(expiration).build()
        );
    }

    private static List<Acl> createVisitor(Role role, Long pageId) {
        AclBuilder aclBuilder = new AclBuilder(role);
        LocalDateTime expiration = LocalDateTime.now().plusHours(12);
        return Arrays.asList(
                aclBuilder.page(pageId).read().expirationIs(expiration).build(),
                aclBuilder.category(ZERO).read().expirationIs(expiration).build(),
                aclBuilder.tag(ZERO).read().expirationIs(expiration).build(),
                aclBuilder.post(ZERO).read().expirationIs(expiration).build(),

                aclBuilder.comment(ZERO).read()  .expirationIs(expiration).build(),
                aclBuilder.comment(ZERO).write() .expirationIs(expiration).build(),
                aclBuilder.comment(ZERO).modify().expirationIs(expiration).build(),
                aclBuilder.comment(ZERO).delete().expirationIs(expiration).build()
        );
    }

    private static List<Acl> createMember(Role role, Long pageId) {
        AclBuilder aclBuilder = new AclBuilder(role);
        LocalDateTime expiration = LocalDateTime.now().plusDays(365);
        return Arrays.asList(
                aclBuilder.page(pageId).read()  .expirationIs(expiration).build(),

                aclBuilder.category(ZERO).read()  .expirationIs(expiration).build(),
                aclBuilder.category(ZERO).write() .expirationIs(expiration).build(),
                aclBuilder.category(ZERO).modify().expirationIs(expiration).build(),
                aclBuilder.category(ZERO).delete().expirationIs(expiration).build(),

                aclBuilder.tag(ZERO).read()  .expirationIs(expiration).build(),
                aclBuilder.tag(ZERO).write() .expirationIs(expiration).build(),
                aclBuilder.tag(ZERO).modify().expirationIs(expiration).build(),
                aclBuilder.tag(ZERO).delete().expirationIs(expiration).build(),

                aclBuilder.post(ZERO).read()  .expirationIs(expiration).build(),
                aclBuilder.post(ZERO).write() .expirationIs(expiration).build(),
                aclBuilder.post(ZERO).modify().expirationIs(expiration).build(),
                aclBuilder.post(ZERO).delete().expirationIs(expiration).build(),

                aclBuilder.comment(ZERO).read()  .expirationIs(expiration).build(),
                aclBuilder.comment(ZERO).write() .expirationIs(expiration).build(),
                aclBuilder.comment(ZERO).modify().expirationIs(expiration).build(),
                aclBuilder.comment(ZERO).delete().expirationIs(expiration).build()
        );
    }

    private static List<Acl> createMaster(Role role, Long pageId) {
        AclBuilder aclBuilder = new AclBuilder(role);
        return Arrays.asList(
                aclBuilder.page(pageId).read()  .expirationIs(null).build(),
                aclBuilder.page(pageId).write() .expirationIs(null).build(),
                aclBuilder.page(pageId).modify().expirationIs(null).build(),
                aclBuilder.page(pageId).delete().expirationIs(null).build(),

                aclBuilder.category(ZERO).read()  .expirationIs(null).build(),
                aclBuilder.category(ZERO).write() .expirationIs(null).build(),
                aclBuilder.category(ZERO).modify().expirationIs(null).build(),
                aclBuilder.category(ZERO).delete().expirationIs(null).build(),

                aclBuilder.tag(ZERO).read()  .expirationIs(null).build(),
                aclBuilder.tag(ZERO).write() .expirationIs(null).build(),
                aclBuilder.tag(ZERO).modify().expirationIs(null).build(),
                aclBuilder.tag(ZERO).delete().expirationIs(null).build(),

                aclBuilder.post(ZERO).read()  .expirationIs(null).build(),
                aclBuilder.post(ZERO).write() .expirationIs(null).build(),
                aclBuilder.post(ZERO).modify().expirationIs(null).build(),
                aclBuilder.post(ZERO).delete().expirationIs(null).build(),

                aclBuilder.comment(ZERO).read()  .expirationIs(null).build(),
                aclBuilder.comment(ZERO).write() .expirationIs(null).build(),
                aclBuilder.comment(ZERO).modify().expirationIs(null).build(),
                aclBuilder.comment(ZERO).delete().expirationIs(null).build()
        );
    }

    private static List<Acl> createAdmin(Role role, Long pageId) {
        throw new IllegalArgumentException("현재 관리자 권한 생성은 지원되지 않습니다.");
    }
}

package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.acl.entity.enumerated.ActionCode;
import com.pollra.pudding.domain.acl.entity.enumerated.ResourceCode;
import com.pollra.pudding.domain.role.entity.Role;

import java.time.LocalDateTime;

/**
 * @since       2021.06.02
 * @author      pollra
 * @description acl builder
 **********************************************************************************************************************/
public class AclBuilder {

    private Role role;
    private Long resourceId;
    private ResourceCode resourceCode;
    private ActionCode actionCode;
    private LocalDateTime expiration;

    private final AclActionBuilder aclActionBuilder = new AclActionBuilder();

    public AclBuilder(Role role) {
        this.role = role;
    }

    public AclActionBuilder page(Long resourceId) {
        this.resourceId = resourceId;
        resourceCode = ResourceCode.PAGE;
        return aclActionBuilder;
    }

    public AclActionBuilder post(Long resourceId) {
        this.resourceId = resourceId;
        resourceCode = ResourceCode.POST;
        return aclActionBuilder;
    }

    public AclActionBuilder tag(Long resourceId) {
        this.resourceId = resourceId;
        resourceCode = ResourceCode.TAG;
        return aclActionBuilder;
    }

    public AclActionBuilder category(Long resourceId) {
        this.resourceId = resourceId;
        resourceCode = ResourceCode.CATEGORY;
        return aclActionBuilder;
    }

    public AclActionBuilder comment(Long resourceId) {
        this.resourceId = resourceId;
        resourceCode = ResourceCode.COMMENT;
        return aclActionBuilder;
    }

    public class AclActionBuilder {
        private final AclExpirationBuilder aclExpirationBuilder = new AclExpirationBuilder();

        public AclExpirationBuilder read() {
            actionCode = ActionCode.READ;
            return aclExpirationBuilder;
        }

        public AclExpirationBuilder write() {
            actionCode = ActionCode.WRITE;
            return aclExpirationBuilder;
        }

        public AclExpirationBuilder modify() {
            actionCode = ActionCode.MODIFY;
            return aclExpirationBuilder;
        }

        public AclExpirationBuilder delete() {
            actionCode = ActionCode.DELETE;
            return aclExpirationBuilder;
        }

        public class AclExpirationBuilder {

            private final AclProvider aclProvider = new AclProvider();

            public AclProvider expirationIs(LocalDateTime expirationDateTime) {
                expiration = expirationDateTime;
                return aclProvider;
            }

            public class AclProvider {
                public Acl build() {
                    return new Acl(role, resourceId, resourceCode, actionCode, expiration);
                }
            }
        }
    }
}
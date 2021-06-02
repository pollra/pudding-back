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
    private ResourceCode resourceCode;
    private ActionCode actionCode;

    private final AclActionBuilder aclActionBuilder = new AclActionBuilder();

    public AclBuilder(Role role) {
        this.role = role;
    }

    public AclActionBuilder page() {
        resourceCode = ResourceCode.PAGE;
        return aclActionBuilder;
    }

    public AclActionBuilder post() {
        resourceCode = ResourceCode.POST;
        return aclActionBuilder;
    }

    public AclActionBuilder tag() {
        resourceCode = ResourceCode.TAG;
        return aclActionBuilder;
    }

    public AclActionBuilder category() {
        resourceCode = ResourceCode.CATEGORY;
        return aclActionBuilder;
    }

    public AclActionBuilder comment() {
        resourceCode = ResourceCode.COMMENT;
        return aclActionBuilder;
    }

    public class AclActionBuilder {
        private final AclProvider aclProvider = new AclProvider();

        public AclProvider read() {
            actionCode = ActionCode.READ;
            return aclProvider;
        }

        public AclProvider write() {
            actionCode = ActionCode.WRITE;
            return aclProvider;
        }

        public AclProvider modify() {
            actionCode = ActionCode.MODIFY;
            return aclProvider;
        }

        public AclProvider delete() {
            actionCode = ActionCode.DELETE;
            return aclProvider;
        }

        public class AclProvider {

            public Acl build() {
                return new Acl(role, resourceCode, actionCode, LocalDateTime.now().plusHours(1));
            }
        }
    }
}
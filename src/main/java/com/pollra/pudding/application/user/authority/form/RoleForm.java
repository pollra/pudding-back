package com.pollra.pudding.application.user.authority.form;

import com.pollra.pudding.domain.acl.entity.enumerated.ResourceCode;
import com.pollra.pudding.domain.role.entity.AuthorityCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @since       2021.06.04
 * @author      pollra
 * @description role form
 **********************************************************************************************************************/
public class RoleForm {

    public static class Request {

        public static class Create {
            @NotBlank
            private String name;

            @NotNull
            private AuthorityCode authorityCode;

            @NotNull
            private Long resourceId;
        }
    }

    public static class Response {

        @Getter
        @Setter
        public static class FindOne {
            private Long id;
            private String roleName;
            private List<Acl> acl;

            @Getter
            @Setter
            public static class Acl {
                private Long id;
                private Long resourceId;
                private ResourceCode resourceCode;
            }
        }
    }
}

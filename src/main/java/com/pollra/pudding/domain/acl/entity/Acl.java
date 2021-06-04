package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.acl.entity.enumerated.ActionCode;
import com.pollra.pudding.domain.acl.entity.enumerated.ResourceCode;
import com.pollra.pudding.domain.role.entity.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "ACL")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Acl {
    @Id @GeneratedValue
    @Column(name = "ACL_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @Embedded
    private Resource resource;
    
    @Enumerated(EnumType.STRING)
    private ActionCode action;
    
    private LocalDateTime expiration;

    protected Acl(final Role role, final Long resourceId, final ResourceCode resourceCode, final ActionCode actionCode, final LocalDateTime expiration) {
        if( Objects.isNull(role) ) throw new IllegalArgumentException("Role 은 Null 일 수 없습니다.");
        if( Objects.isNull(actionCode) ) throw new IllegalArgumentException("Action 은 Null 일 수 없습니다.");
        this.role = role;
        this.resource = new Resource(resourceId, resourceCode);
        this.action = actionCode;
        this.expiration = expiration;
    }
}

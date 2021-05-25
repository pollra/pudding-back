package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.acl.enumerated.ActionCode;
import com.pollra.pudding.domain.acl.enumerated.ResourceCode;
import com.pollra.pudding.domain.role.entity.Role;

import javax.persistence.*;

@Entity
@Table(name = "ACL")
public class Acl {
    @Id @GeneratedValue
    @Column(name = "ACL_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @Enumerated(EnumType.STRING)
    private ResourceCode resource;
    
    @Enumerated(EnumType.STRING)
    private ActionCode action;
    
    private String expiration;
}

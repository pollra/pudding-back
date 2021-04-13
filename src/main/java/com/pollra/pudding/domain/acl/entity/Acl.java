package com.pollra.pudding.domain.acl.entity;

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

    private String condition;
    private String action;
    private String expiration;
}

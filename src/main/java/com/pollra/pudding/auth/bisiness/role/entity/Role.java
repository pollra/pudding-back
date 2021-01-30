package com.pollra.pudding.auth.bisiness.role.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {
    @Id @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(nullable = false)
    private String name;
}

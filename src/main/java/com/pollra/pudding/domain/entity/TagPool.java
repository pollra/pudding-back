package com.pollra.pudding.domain.entity;

import com.pollra.pudding.domain.acl.entity.Acl;
import com.pollra.pudding.infra.base.entity.Sign;

import javax.persistence.*;

@Entity
@Table(name = "TAG_POOL")
public class TagPool extends Sign {
    @Id @GeneratedValue
    @Column(name = "POOL_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ACL_ID")
    private Acl acl;

    private String name;
    private String description;
}

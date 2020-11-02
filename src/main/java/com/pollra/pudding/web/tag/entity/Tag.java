package com.pollra.pudding.web.tag.entity;

import com.pollra.pudding.common.base.entity.Sign;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag extends Sign {
    @Id @GeneratedValue
    private Long id;
    private Long poolId;
    private Long aclId;
    private Long postId;
    private String name;
    private String description;
}

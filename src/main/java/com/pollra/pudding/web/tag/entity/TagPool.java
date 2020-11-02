package com.pollra.pudding.web.tag.entity;

import com.pollra.pudding.common.base.entity.Sign;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TagPool extends Sign {
    @Id @GeneratedValue
    private Long id;
    private Long aclId;
    private String name;
    private String description;
}

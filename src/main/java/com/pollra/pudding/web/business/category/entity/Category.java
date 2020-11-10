package com.pollra.pudding.web.business.category.entity;

import com.pollra.pudding.common.base.entity.Sign;
import com.pollra.pudding.web.business.category.enumerated.CategoryStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category extends Sign {
    @Id @GeneratedValue
    private Long id;
    private Long aclId;
    private Long parentId;
    private String name;
    private CategoryStatus status;
}

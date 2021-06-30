package com.pollra.pudding.domain.category.entity;

import com.pollra.pudding.infra.base.entity.Sign;
import com.pollra.pudding.domain.category.enumerated.CategoryStatus;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category extends Sign {
    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;
    private Long aclId;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category parent;
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryStatus status;
}

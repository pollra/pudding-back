package com.pollra.pudding.domain.post.entity;

import com.pollra.pudding.domain.acl.entity.Acl;
import com.pollra.pudding.infra.base.entity.Sign;
import com.pollra.pudding.domain.category.entity.Category;
import com.pollra.pudding.domain.post.enumerated.PostStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "POST")
public class Post extends Sign {

    @Id @GeneratedValue
    @Column(name = "POST_ID")
    private Long id;

    @ManyToMany
    @JoinTable(name="post_acl")
    private List<Acl> acl = new ArrayList<>();

    private String title;
    private Long viewCount;

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    private String content;
}

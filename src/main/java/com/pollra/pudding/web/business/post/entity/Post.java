package com.pollra.pudding.web.business.post.entity;

import com.pollra.pudding.auth.bisiness.acl.entity.Acl;
import com.pollra.pudding.common.base.entity.Sign;
import com.pollra.pudding.web.business.category.entity.Category;
import com.pollra.pudding.web.business.post.enumerated.PostStatus;

import javax.persistence.*;

@Entity
@Table(name = "POST")
public class Post extends Sign {
    @Id @GeneratedValue
    @Column(name = "POST_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ACL_ID")
    private Acl acl;

    private String title;
    private Long viewCount;

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    private String content;
}

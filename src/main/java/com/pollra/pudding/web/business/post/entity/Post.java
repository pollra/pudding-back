package com.pollra.pudding.web.business.post.entity;

import com.pollra.pudding.common.base.entity.Sign;
import com.pollra.pudding.web.business.category.entity.Category;
import com.pollra.pudding.web.business.post.enumerated.PostStatus;

import javax.persistence.*;

@Entity
public class Post extends Sign {
    @Id @GeneratedValue
    private Long id;
    private Long aclId;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    private String title;
    private Long viewCount;
    private PostStatus status;


    private String content;
}

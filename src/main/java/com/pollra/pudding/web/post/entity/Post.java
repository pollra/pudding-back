package com.pollra.pudding.web.post.entity;

import com.pollra.pudding.common.base.entity.Sign;
import com.pollra.pudding.web.post.enumerated.PostStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post extends Sign {
    @Id @GeneratedValue
    private Long id;
    private Long aclId;
    private Long categoryId;
    private String title;
    private Long viewCount;
    private PostStatus status;

    private String content;
}

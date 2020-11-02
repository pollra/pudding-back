package com.pollra.pudding.web.comment.entity;

import com.pollra.pudding.common.base.entity.Sign;
import com.pollra.pudding.web.comment.enumerated.CommentStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment extends Sign {
    @Id @GeneratedValue
    private Long id;

    private Long coordinatesId;
    private Long parentId;
    private String content;
    private CommentStatus status;
}

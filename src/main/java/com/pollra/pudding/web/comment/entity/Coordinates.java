package com.pollra.pudding.web.comment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coordinates {
    @Id @GeneratedValue
    private Long id;
    private Long postId;

    private String dom;
    private Long pathX;
    private Long pathY;
    private Long commentCount;
}

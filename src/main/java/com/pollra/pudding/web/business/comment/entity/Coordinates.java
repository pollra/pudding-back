package com.pollra.pudding.web.business.comment.entity;

import com.pollra.pudding.web.business.post.entity.Post;

import javax.persistence.*;

@Entity
@Table(name = "COORDINATES")
public class Coordinates {
    @Id @GeneratedValue
    @Column(name = "COORDINATES_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    private String dom;
    private Long pathX;
    private Long pathY;
    private Long commentCount;
}

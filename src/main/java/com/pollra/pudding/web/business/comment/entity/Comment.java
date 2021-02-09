package com.pollra.pudding.web.business.comment.entity;

import com.pollra.pudding.common.base.entity.Sign;
import com.pollra.pudding.web.business.comment.enumerated.CommentStatus;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
public class Comment extends Sign {
    @Id @GeneratedValue
    @Column(name = "COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COORDINATES_ID")
    private Coordinates coordinates;

    @OneToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment parent;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private CommentStatus status;
}

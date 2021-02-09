package com.pollra.pudding.web.business.tag.entity;

import com.pollra.pudding.auth.bisiness.acl.entity.Acl;
import com.pollra.pudding.common.base.entity.Sign;
import com.pollra.pudding.web.business.post.entity.Post;

import javax.persistence.*;

@Entity
@Table(name = "TAG")
public class Tag extends Sign {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POOL_ID")
    private TagPool pool;

    @ManyToOne
    @JoinColumn(name = "ACL_ID")
    private Acl acl;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;
    private String name;
    private String description;
}

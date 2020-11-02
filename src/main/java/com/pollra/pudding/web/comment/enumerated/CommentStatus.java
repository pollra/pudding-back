package com.pollra.pudding.web.comment.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  CommentStatus {
     PUBLIC("공개")
    ,PRIVATE("비공개")
    ,PROTECTED("보호")
    ,BLOCK("블락");

    private String description;
}

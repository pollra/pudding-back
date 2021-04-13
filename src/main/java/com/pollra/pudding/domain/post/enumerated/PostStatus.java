package com.pollra.pudding.domain.post.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostStatus {
     PUBLIC   ("공개"  )
    ,PRIVATE  ("비공개")
    ,PROTECTED("보호"  )
    ,BLOCK    ("블락"  );

     private String description;
}

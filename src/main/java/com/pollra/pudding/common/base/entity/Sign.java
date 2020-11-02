package com.pollra.pudding.common.base.entity;

import com.pollra.pudding.common.base.annotation.Description;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class Sign {

    @Description("생성자")
    private String createdAt;

    @Description("생성일")
    private LocalDateTime createdDt;

    @Description("수정자")
    private String updatedAt;

    @Description("수정일")
    private LocalDateTime updatedDt;
}
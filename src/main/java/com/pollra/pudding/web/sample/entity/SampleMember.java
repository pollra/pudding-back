package com.pollra.pudding.web.sample.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @since       2021.01.28
 * @author      pollra
 * @description SampleMember
 **********************************************************************************************************************/
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="SAMPLE_MEMBER")
public class SampleMember {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Integer age;

    @Column(nullable=false, updatable=false)
    @CreatedDate
    private LocalDateTime createdDate;
}

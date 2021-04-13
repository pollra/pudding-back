package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.domain.role.enumerated.AuthorityCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor(access=AccessLevel.PROTECTED)
public class Role {
    @Id @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(nullable = false)
    private AuthorityCode authorityCode;
}

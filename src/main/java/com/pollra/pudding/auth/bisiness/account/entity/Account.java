package com.pollra.pudding.auth.bisiness.account.entity;

import com.pollra.pudding.auth.bisiness.role.entity.Role;
import com.pollra.pudding.common.base.annotation.Description;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ACCOUNT")
public class Account {
    @Id @GeneratedValue
    @Column(name="ACCOUNT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private Role role;

    @Description("아이디(Guest:IP, User:Email)")
    @Column(nullable=false, unique=true)
    private String identity;

    @Column(nullable=false, unique=true)
    private String nickname;

    @Column(nullable=false)
    private String password;
}
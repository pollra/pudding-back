package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.domain.acl.entity.Acl;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@Table(name = "ROLE")
public class Role {
    @Id @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long id;

	@Embedded
    private RoleName roleName;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
	private final List<Acl> acls = new ArrayList<>();
}

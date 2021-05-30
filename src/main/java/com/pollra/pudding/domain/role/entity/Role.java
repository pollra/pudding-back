package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.domain.acl.entity.Acl;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ROLE")
public class Role {
    @Id @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long id;

	@Embedded
    private RoleName roleName;

	@Getter
	@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
	private final List<Acl> acls = new ArrayList<>();

	protected Role(final RoleName roleName) {
	    if(Objects.isNull(roleName)) {
	        throw new IllegalArgumentException("권한 이름은 null일 수 없습니다.");
        }
	    this.roleName = roleName;
    }

    public String getRoleName() {
		return roleName.getName();
	}
}

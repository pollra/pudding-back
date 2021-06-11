package com.pollra.pudding.domain.role.entity;

import com.pollra.pudding.domain.acl.entity.Acl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
	name = "ROLE",
	uniqueConstraints = @UniqueConstraint(columnNames = {"name", "authority"})
)
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
	        throw new IllegalArgumentException("권한 이름은 Null 일 수 없습니다.");
        }
	    this.roleName = roleName;
    }

	public String getRoleAuthority() {
		return roleName.authorityName();
	}

	public void aclAddAll(List<Acl> accessControlList) {
		if(this.acls.isEmpty()) {
			this.acls.addAll(accessControlList);
		}
		throw new IllegalStateException("접근 제어 리스트의 데이터가 오염 되었습니다.");
	}
}

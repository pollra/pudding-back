package com.pollra.pudding.domain.role.service;

import com.pollra.pudding.domain.acl.entity.AclFactory;
import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.domain.role.entity.RoleFactory;
import com.pollra.pudding.domain.role.persistentor.RoleRepository;
import com.pollra.pudding.domain.role.service.command.RoleCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description RoleService
 **********************************************************************************************************************/
@Service // TODO: 2021/06/04 Domain Service 가 Bean 으로 등록되는게 정말 맞는건가?
@RequiredArgsConstructor
public class RoleService {

	// TODO: 2021/06/04 의존성 주입이 사용되는게 맞는건가? 외부에서 주입받으면 좋지않을까?
	private final RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public Role getGuestAuthority() {
		Role guestRole = RoleFactory.guestRole();
		return roleRepository.findByRoleName(guestRole);
	}
	// TODO: 2021/06/04 여기서 Command 패턴을 사용하여 Application Service 와 통신하는 것이 맞는것인가?
	public Role createRole(final RoleCommand.Request.Create create) {
		Role role = RoleFactory.newRole(create.getName(), create.getAuthorityCode());
		// TODO: 2021/06/04 과연 여기에 AclFactory 가 있는게 맞는것인가?
		role.aclAddAll( AclFactory.defaultRoleSet(role, create.getResourceId()) );
		return roleRepository.save(role);
	}
}

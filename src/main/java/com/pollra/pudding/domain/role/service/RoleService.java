package com.pollra.pudding.domain.role.service;

import com.pollra.pudding.domain.role.entity.AuthorityCode;
import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.domain.role.entity.RoleFactory;
import com.pollra.pudding.domain.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description RoleService
 **********************************************************************************************************************/
@Service
@RequiredArgsConstructor
public class RoleService {
	
	private final RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public Role getGuestAuthority() {
		Role guestRole = RoleFactory.guestRole();
		return roleRepository.findByRoleName(guestRole);
	}

	/**
	 * 새로운 권한 생성
	 * 고객의 요청에 따라 새로운 권한을 만들 수 있습니다.
	 * @name 	새로 부여할 권한의 이름
	 * @code 	권한 레벨
	 * @return 	만들어진 권한
	 */
	public Role newAuthority(final String name, final AuthorityCode code) {

		return null;
	}
}

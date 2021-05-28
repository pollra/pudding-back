package com.pollra.pudding.domain.role.service;

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
	public Role getGuestRole() {
		Role guestRole = RoleFactory.guestRole();
		return roleRepository.findByRoleName(guestRole);
	}
}

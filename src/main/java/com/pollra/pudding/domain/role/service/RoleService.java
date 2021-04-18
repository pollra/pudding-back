package com.pollra.pudding.domain.role.service;

import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.domain.role.entity.RoleName;
import com.pollra.pudding.domain.role.entity.RoleNameFactory;
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
	
	@Transactional
	public Role guestRole() {
		RoleName guestRoleName = RoleNameFactory.guestRoleName();
		return roleRepository.findByRoleName(guestRoleName);
	}
}

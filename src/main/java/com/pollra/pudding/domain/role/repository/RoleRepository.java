package com.pollra.pudding.domain.role.repository;

import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.domain.role.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description RoleRepository
 **********************************************************************************************************************/
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleName(Role role);
}

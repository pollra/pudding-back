package com.pollra.pudding.domain.acl.persistentor;

import com.pollra.pudding.domain.acl.entity.Acl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @since       2021.06.02
 * @author      pollra
 * @description acl repository
 **********************************************************************************************************************/
public interface AclRepository extends JpaRepository<Acl, Long> {
}

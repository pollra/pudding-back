package com.pollra.pudding.domain.acl.repository;

import com.pollra.pudding.domain.acl.entity.Acl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pollra
 * @description acl repository
 * @since 2021.06.02
 **********************************************************************************************************************/
public interface AclRepository extends JpaRepository<Acl, Long> {
}

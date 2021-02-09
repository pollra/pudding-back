package com.pollra.pudding.web.sample.repository;

import com.pollra.pudding.web.sample.entity.SampleMember;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @since       2021.01.28
 * @author      pollra
 * @description SampleMemberRepository
 **********************************************************************************************************************/
public interface SampleMemberRepository extends JpaRepository<SampleMember, Long> {
}

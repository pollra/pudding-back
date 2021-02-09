package com.pollra.pudding.web.sample.service;

import com.pollra.pudding.web.sample.entity.SampleMember;
import com.pollra.pudding.web.sample.repository.SampleMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @since       2021.01.28
 * @author      pollra
 * @description SampleMemberService
 **********************************************************************************************************************/
@Service
@RequiredArgsConstructor
public class SampleMemberService {
    private final SampleMemberRepository sampleMemberRepository;

    @Transactional(readOnly=true)
    public SampleMember find(SampleMember entity){
        return sampleMemberRepository.getOne(entity.getId());
    }

    public SampleMember add(SampleMember entity) {
        entity.setCreatedDate(LocalDateTime.now());
        return sampleMemberRepository.save(entity);
    }
}

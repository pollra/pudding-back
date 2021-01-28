package com.pollra.pudding.web.sample.mapper;

import com.pollra.pudding.web.sample.entity.SampleMember;
import com.pollra.pudding.web.sample.form.SampleMemberForm.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @since       2021.01.29
 * @author      pollra
 * @description SampleMemberMapper
 **********************************************************************************************************************/
@Mapper(unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface SampleMemberMapper {
    SampleMemberMapper mapper = Mappers.getMapper(SampleMemberMapper.class);

    SampleMember toSampleMember(Request.Add form);
    SampleMember toSampleMember(Long id);

    Response.FindOne toFindOne(SampleMember entity);
}

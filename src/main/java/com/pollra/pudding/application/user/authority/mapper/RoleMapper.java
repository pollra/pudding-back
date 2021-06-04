package com.pollra.pudding.application.user.authority.mapper;

import com.pollra.pudding.application.user.authority.form.RoleForm;
import com.pollra.pudding.domain.role.service.command.RoleCommand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @since       2021.06.04
 * @author      pollra
 * @description role mapper
 **********************************************************************************************************************/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    RoleMapper mapper = Mappers.getMapper(RoleMapper.class);

    RoleCommand.Request.Create toCreate(RoleForm.Request.Create form);

    RoleForm.Response.FindOne toFindOne(RoleCommand.Response.Create command);
}

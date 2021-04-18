package com.pollra.pudding.application.user.account.mapper;

import com.pollra.pudding.application.user.account.form.AccountForm;
import com.pollra.pudding.domain.account.service.command.AccountCommand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.pollra.pudding.application.user.account.form.AccountForm.*;


/**
 * @since       2021.04.15
 * @author      pollra
 * @description AccountApplicationMapper
 **********************************************************************************************************************/
@Mapper(unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface AccountApplicationMapper {
	AccountApplicationMapper mapper =Mappers.getMapper(AccountApplicationMapper.class);
	
	Response.FineOne toFindOne(AccountCommand.Response.Create command);
	
	AccountCommand.Request.Create toRequestCommand(AccountForm.Request.Create form);
}

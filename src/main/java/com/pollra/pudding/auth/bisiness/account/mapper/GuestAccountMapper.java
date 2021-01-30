package com.pollra.pudding.auth.bisiness.account.mapper;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import com.pollra.pudding.auth.bisiness.account.form.GuestAccountForm.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @since       2021.01.31
 * @author      pollra
 * @description GuestAccountMapper
 **********************************************************************************************************************/
@Mapper(unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface GuestAccountMapper {
    GuestAccountMapper mapper = Mappers.getMapper(GuestAccountMapper.class);

    Account toAccount(Request.Add form);
    Account toAccount(Long id);

    Response.AddSuccess toAddSuccess(Account entity);
    Response.FindOne    toFindOne(Account entity);

}

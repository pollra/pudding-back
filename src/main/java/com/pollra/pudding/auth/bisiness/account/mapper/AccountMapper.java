package com.pollra.pudding.auth.bisiness.account.mapper;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import com.pollra.pudding.auth.bisiness.account.form.AccountForm.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface AccountMapper {
    AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

    Account toAccount(Request.Add form);
    Account toAccount(Request.FindOne form);
}

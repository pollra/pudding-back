package com.pollra.pudding.auth.bisiness.account.mapper;

import com.pollra.pudding.auth.bisiness.account.entity.Account;
import com.pollra.pudding.auth.bisiness.account.form.AccountForm.*;
import com.pollra.pudding.common.engine.filter.jwt.domain.Credential;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface AccountMapper {
    AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

    Account toAccount(Request.Add form);
    Account toAccount(Request.FindOne form);

    @Mappings({
             @Mapping(target = "nickname", source = "credential.name")
            ,@Mapping(target = "role.name", source = "credential.role") // 매핑할 때 에러 발생
    })
    Account toAccount(Credential credential);

    @Mappings({
             @Mapping(target = "name", source = "nickname")
            ,@Mapping(target = "role", source = "role.name")
    })
    Credential toCredential(Account entity);

}

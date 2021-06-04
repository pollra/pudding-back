package com.pollra.pudding.application.user.authority.service;

import com.pollra.pudding.domain.role.service.command.RoleCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @since       2021.06.04
 * @author      pollra
 * @description role application service
 **********************************************************************************************************************/
@Service
@RequiredArgsConstructor
public class RoleApplicationService {

    public RoleCommand.Response.Create createNewRole(RoleCommand.Request.Create create) {

        // TODO: 2021/06/04 여기에서 Command 객체는 정말 보내져야 하는게 맞는건가?
        // 만약 보내져야 한다면 모든 applicationService 에서 모든 도메인 모델과 통신할 때 Command 패턴이 반드시 들어가야 하는데, 의미가 있나?
//        return roleService.createRole(create);
        return null;
    }
}

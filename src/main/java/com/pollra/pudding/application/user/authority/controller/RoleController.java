package com.pollra.pudding.application.user.authority.controller;

import com.pollra.pudding.application.user.authority.form.RoleForm;
import com.pollra.pudding.application.user.authority.service.RoleApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pollra.pudding.application.user.authority.mapper.RoleMapper.mapper;

/**
 * @since       2021.06.04
 * @author      pollra
 * @description role controller
 **********************************************************************************************************************/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoleController {

    private final RoleApplicationService roleApplicationService;

    @PostMapping("/roles")
    public RoleForm.Response.FindOne add(RoleForm.Request.Create create) {
        return mapper.toFindOne(roleApplicationService.createNewRole(mapper.toCreate(create)));
    }
}

package com.pollra.pudding.auth.bisiness.account.controller;

import com.pollra.pudding.auth.bisiness.account.form.GuestAccountForm.Request;
import com.pollra.pudding.auth.bisiness.account.form.GuestAccountForm.Response;
import com.pollra.pudding.auth.bisiness.account.service.GuestAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.pollra.pudding.auth.bisiness.account.mapper.GuestAccountMapper.mapper;
/**
 * @since       2021.01.31
 * @author      pollra
 * @description GuestAccountController
 **********************************************************************************************************************/
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blogs/guests")
public class GuestAccountController {

    private final GuestAccountService guestAccountService;

    @PostMapping
    public Response.AddSuccess add(@RequestBody @Valid Request.Add add) {
        log.info("Create request of Account info: "+add);
        return mapper.toAddSuccess(guestAccountService.add(mapper.toAccount(add)));
    }

    @GetMapping("/{id}")
    public Response.FindOne findOne(@PathVariable Long id) {
        return mapper.toFindOne(guestAccountService.findOne(mapper.toAccount(id)));
    }
}

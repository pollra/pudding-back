package com.pollra.pudding.auth.bisiness.account.controller;

import com.pollra.pudding.auth.bisiness.account.adapter.GuestAccountAdapter;
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
    private final GuestAccountAdapter guestAccountAdapter;

    @PostMapping
    public Response.FindOne add(@RequestBody @Valid Request.Add add) {
        return mapper.toFindOne(guestAccountService.add(mapper.toAccount(add)));
    }

    @GetMapping("/{id}")
    public Response.FindOne findOne(@PathVariable Long id) {
        return mapper.toFindOne(guestAccountService.findOne(mapper.toAccount(id)));
    }

    @PatchMapping("/{id}/nickname")
    public int modifiedNickname(@PathVariable Long id, @Valid @RequestBody Request.Modify modify) {
        return guestAccountAdapter.changeNickname(mapper.toAccount(id, modify));
    }

    /**
     * modified identity
     * @param id
     * @param modify
     * @return
     */
    @PatchMapping("/{id}/identity")
    public int modifiedIdentity(@PathVariable Long id, @Valid @RequestBody Request.Modify modify) {
        return guestAccountAdapter.modifiedAccountIdentity(mapper.toAccount(id, modify));
    }
}

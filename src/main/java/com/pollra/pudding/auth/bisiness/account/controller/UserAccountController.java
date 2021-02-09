package com.pollra.pudding.auth.bisiness.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${property.api.end-point}/blogs/user")
public class UserAccountController {

    @GetMapping("beantest/{text}")
    public String hello(@PathVariable String text) {
        return "Hello, "+text;
    }
}

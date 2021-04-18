package com.pollra.pudding.application.user.account.controller;

import com.pollra.pudding.application.user.account.form.AccountForm.Request;
import com.pollra.pudding.application.user.account.form.AccountForm.Response;
import com.pollra.pudding.application.user.account.service.AccountApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.pollra.pudding.application.user.account.mapper.AccountApplicationMapper.mapper;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description AccountController
 **********************************************************************************************************************/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccountController {

	private final AccountApplicationService accountApplicationService;
	
	@PostMapping("/accounts")
	public Response.FineOne create(@Valid @RequestBody Request.Create create) {
		return mapper.toFindOne(accountApplicationService.create(mapper.toRequestCommand(create)));
	}
}

package com.hirm159.loginappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hirm159.loginappapi.common.dto.account.AccountInputDto;
import com.hirm159.loginappapi.common.dto.account.AccountResultDto;
import com.hirm159.loginappapi.common.dto.account.AccountUpdateDto;
import com.hirm159.loginappapi.common.entity.Account;
import com.hirm159.loginappapi.service.AccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

	@Autowired
	AccountService accountService;
	
	// 新規アカウント作成処理
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public AccountResultDto createAccount (@RequestBody AccountInputDto input) {
		AccountResultDto result = new AccountResultDto();

		if (accountService.checkUsername(input.getUsername())) {
			Account newAccount = accountService.accountInput(input);
			result.result = "SUCCESS";
			result.message = "アカウントの作成が完了しました。";
			result.setId(newAccount.getId());
		} else {
			result.result = "NG";
			result.message = "すでに存在するユーザー名です。";
			result.setId(0);
		}
		result.setUsername(input.getUsername());
		result.setMailAddress(input.getMailAddress());
		return result;
	}

	// アカウント更新処理
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public void updateAccount (@RequestBody AccountUpdateDto input) {
		accountService.accountUpdate(input);
	}


	// アカウント削除処理

	// アカウント検索処理

	// 新規アカウント作成リクエスト処理


}

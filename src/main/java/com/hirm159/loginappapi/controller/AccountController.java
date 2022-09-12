package com.hirm159.loginappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hirm159.loginappapi.common.dto.AccountInputDto;
import com.hirm159.loginappapi.common.dto.AccountUpdateDto;
import com.hirm159.loginappapi.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	// 新規アカウント作成処理
	public void createAccount (AccountInputDto input) {
		accountService.accountInput(input);

	}

	// アカウント更新処理
	public void updateAccount (AccountUpdateDto input) {
		accountService.accountUpdate(input);
	}

	// アカウント削除処理

	// アカウント検索処理

	// 新規アカウント作成リクエスト処理


}

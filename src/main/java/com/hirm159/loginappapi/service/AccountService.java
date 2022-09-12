package com.hirm159.loginappapi.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirm159.loginappapi.common.dto.AccountInputDto;
import com.hirm159.loginappapi.common.dto.AccountUpdateDto;
import com.hirm159.loginappapi.common.entity.Account;
import com.hirm159.loginappapi.common.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	// ACCOUNTへのINSERT処理
	public Account accountInput(AccountInputDto input) {
		Account inputAccount = new Account();
		inputAccount.setUsername(input.getUsername());
		inputAccount.setPassword(input.getPassword());
		inputAccount.setMailAddress(input.getMailAddress());

		Timestamp nowTime = new Timestamp(System.currentTimeMillis());

		inputAccount.setFirstDate(nowTime);
		inputAccount.setLastDate(nowTime);
		inputAccount.setVersion(0);

		accountRepository.save(inputAccount);

		return inputAccount;
	}

	// 既存アカウントへの更新処理
	public Account accountUpdate(AccountUpdateDto input) {
		Account account = new Account();
		
		if (!accountRepository.existsById(input.getId())) {
			return null;
		}
		
		account.setId(input.getId());
		account.setPassword(input.getMailAddress());
		account.setMailAddress(input.getMailAddress());

		accountRepository.save(account);
		return account;
	}
}

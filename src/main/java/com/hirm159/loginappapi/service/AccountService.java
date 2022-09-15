package com.hirm159.loginappapi.service;

import java.sql.Timestamp;

import org.apache.commons.codec.digest.DigestUtils;
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
		inputAccount.setPassword(createPassword(input.getUsername(), input.getPassword()));
		inputAccount.setMailAddress(input.getMailAddress());

		inputAccount.setFirstDate(nowTime());
		inputAccount.setLastDate(nowTime());
		inputAccount.setVersion(0);

		accountRepository.save(inputAccount);

		return inputAccount;
	}

	// 既存アカウントへの更新処理
	public Account accountUpdate(AccountUpdateDto input) {
		if (!accountRepository.existsById(input.getId())) {
			return null;
		}

		Account account = accountRepository.getReferenceById(input.getId());

		account.setId(input.getId());
		account.setPassword(createPassword(account.getUsername(), input.getPassword()));
		account.setMailAddress(input.getMailAddress());
		account.setLastDate(nowTime());
		account.setVersion(account.getVersion() + 1);

		accountRepository.save(account);
		return account;
	}

	// パスワード生成処理
	private String createPassword(String username, String password) {
		if (username != null && password != null) {
			String newPassword = DigestUtils.md5Hex(username + password) ;
			return newPassword;
		}
		return null;
	}

	// 時刻更新処理
	private Timestamp nowTime() {
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		return nowTime;
	}

}

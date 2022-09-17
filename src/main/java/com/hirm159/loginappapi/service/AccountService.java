package com.hirm159.loginappapi.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.hirm159.loginappapi.common.dto.account.AccountInputDto;
import com.hirm159.loginappapi.common.dto.account.AccountUpdateDto;
import com.hirm159.loginappapi.common.entity.Account;
import com.hirm159.loginappapi.common.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	// ACCOUNTへのINSERT処理
	public Account accountInput(AccountInputDto input) {
		Account inputAccount = new Account();
		inputAccount.setUsername(input.getUsername());
		inputAccount.setPassword(createPassword(input.getUsername(), input.getPassword()));
		inputAccount.setMailAddress(input.getMailAddress());
		inputAccount.setDeleteFlg(0);
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

	// ユーザー名の重複チェック
	public boolean checkUsername(String username) {
		String sql = """
				SELECT
				    COUNT(*) 
				FROM
				    account 
				WHERE
				    username = :username
				""";
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		Integer count = (Integer) jdbcTemplate.queryForObject(sql, params, Integer.class);
		if (count < 1) {
			return true;
		}

		return false;
	}
}

//package com.hirm159.loginappapi.repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.sql.Timestamp;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//
//import com.hirm159.loginappapi.common.entity.Account;
//import com.hirm159.loginappapi.common.repository.AccountRepository;
//
//
//@AutoConfigureTestDatabase
//public class AccountRepositoryTest {
//
//	@Autowired
//	private AccountRepository accountRepository;
//
//	@Test
//	public void test() {
//		Integer id = 1;
//		String name = "test";
//		String password = "password";
//		String mailAddress = "mail";
//		Timestamp firstDate = new Timestamp(System.currentTimeMillis());
//		Timestamp lastDate = new Timestamp(System.currentTimeMillis());
//		Account newAccount = accountRepository
//			.save(new Account(id, name, password, mailAddress, 0,  firstDate, lastDate, 0));
//
//		assertEquals(newAccount.getId(), 1);
//	}
//
//}

package com.hirm159.loginappapi.common.dto.account;

import lombok.Data;

@Data
public class AccountUpdateDto {

	public Integer id;
	
	public String password;

	public String mailAddress;
}

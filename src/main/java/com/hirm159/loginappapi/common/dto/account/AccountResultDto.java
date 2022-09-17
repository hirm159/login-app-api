package com.hirm159.loginappapi.common.dto.account;

import com.hirm159.loginappapi.common.dto.CommonResultDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountResultDto extends CommonResultDto{

	public Integer id;

	public String username;

	public String mailAddress;

}

package com.hirm159.loginappapi.common.dto.account;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountInputDto extends AccountCommonDto {

    public String mailAddress;

}

package com.hirm159.loginappapi.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Test {

	@Id
	public int id;

	public String name;
}

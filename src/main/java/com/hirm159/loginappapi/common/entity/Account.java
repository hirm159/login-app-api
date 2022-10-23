package com.hirm159.loginappapi.common.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String username;

	private String password;

	private String mailAddress;

	private Integer deleteFlg;

	private Timestamp firstDate;

	private Timestamp lastDate;

	private Integer version;

}

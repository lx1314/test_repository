package com.ligaojie.user.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "user")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 账号
	@Column(name = "USER_NAME")
	private String userName;

	// 名字
	@Column(name = "NAME")
	private String name;

	// 年龄
	@Column(name = "AGE")
	private Long age;

	// 金额
	@Column(name = "BALANCE")
	private BigDecimal balance;

}

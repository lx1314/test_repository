package com.ligaojie.user.entity;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//商品名称
	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "CAGETORY")
	private String cagetory;

	@Column(name = "DETAIL")
	private String detail;

	@Column(name = "BUY_PRICE")
	private BigDecimal buyPrice;
	
	@Column(name = "SELL_PRICE")
	private BigDecimal sellPrice;
	
	@Column(name = "PROVIDER")
	private String provider;
	
	@Column(name = "ONLINE_TIME")
	private Date onlineTime;
	
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
	

}

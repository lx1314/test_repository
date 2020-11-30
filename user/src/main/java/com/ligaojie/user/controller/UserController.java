  package com.ligaojie.user.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ligaojie.user.entity.Product;
import com.ligaojie.user.entity.User;
import com.ligaojie.user.mapper.TpromoActivityMapper;
import com.ligaojie.user.mapper.UserDao;
import com.ligaojie.user.service.ProductTestService;

@RestController
public class UserController {
	
	@Autowired
	private TpromoActivityMapper mapper;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductTestService productTestService;
	
	@GetMapping(value = "/get")
	public String getStringList() {

		return "测试发布成功，为了测试自动部署是否成功";
	}
	
	@PostMapping(value = "/insert/product")
	public Object insertProduct() {
		Product product = new Product();
		product.setProductName("商品343gwerg36hh2831");
		product.setBuyPrice(new BigDecimal(11));
		product.setCagetory("0000");
		product.setDetail("这是一个商品");
		product.setOnlineTime(new Date());
		product.setProvider("admin");
		product.setSellPrice(new BigDecimal(12));
		product.setUpdateTime(new Date());
		Object insertProduce = productTestService.insertProduce(product);
		return insertProduce;
	}	
	
//	@PostMapping(value = "update/product")
//	public int insertProduct() {
//		return productDao.insert();
//	}
//	
	@GetMapping(value = "select")
	public List<User> finActivityEntity() {
		return userDao.selectAll();
	}

	
	@PostMapping(value = "update/user")
	public int updateUser(@RequestBody User user) {
		return userDao.updateByPrimaryKey(user);
	}

	@PostMapping(value = "insert/user")
	public int insertUser(@RequestBody User user) {
		return userDao.insert(user);
	}
	@GetMapping(value = "find/user/{id}")
	public User selectUsers(@PathVariable("id") Long idLong) {
		User user = new User();
		user.setId(idLong);
		return userDao.selectByPrimaryKey(user);
	}

//	@Override
//	public Health health() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}

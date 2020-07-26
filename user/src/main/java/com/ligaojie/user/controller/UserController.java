package com.ligaojie.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ligaojie.user.entity.User;
import com.ligaojie.user.mapper.TpromoActivityMapper;
import com.ligaojie.user.mapper.UserDao;

@RestController
public class UserController {
	
	@Autowired
	private TpromoActivityMapper mapper;
	
	@Autowired
	private UserDao userDao;
	
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

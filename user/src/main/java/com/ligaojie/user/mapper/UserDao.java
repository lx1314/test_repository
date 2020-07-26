package com.ligaojie.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ligaojie.user.entity.User;
import com.ligaojie.user.mymapper.MyMapper;

@Mapper
public interface UserDao  extends MyMapper<User>{

}

package com.ligaojie.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ligaojie.user.entity.Product;
import com.ligaojie.user.mymapper.MyMapper;

@Mapper
public interface ProductTestDao extends MyMapper<Product>{
	
//	public Product findProductById(Long id);

}

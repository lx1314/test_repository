package com.ligaojie.user.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligaojie.user.entity.Product;
import com.ligaojie.user.mapper.ProductTestDao;
import com.ligaojie.user.service.ProductTestService;
@Service
public class ProductServiceImpl implements ProductTestService{
	
	@Autowired
	private ProductTestDao produceDao;

	@Override
	@Transactional
	public Object insertProduce(Product product) {
		return produceDao.insert(product);
	}

	@Override
	public Product findProductById(Long id) {
	
		return produceDao.selectByPrimaryKey(id);
	}

}

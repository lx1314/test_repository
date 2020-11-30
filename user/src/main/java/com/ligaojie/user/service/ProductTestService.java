package com.ligaojie.user.service;

import com.ligaojie.user.entity.Product;

public interface ProductTestService {
	
	Object insertProduce(Product product);
	
	Product findProductById(Long id);

}

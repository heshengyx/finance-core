package com.myself.finance.dao;

import java.util.List;

import com.myself.finance.entity.Product;
import com.myself.finance.param.ProductQueryParam;

public interface IProductDao {

	int save(Product param);
	int update(Product param);
	int delete(Product param);
	Product getData(Product param);
	
	int count(ProductQueryParam param);
	List<Product> query(ProductQueryParam param, int start, int end);
}

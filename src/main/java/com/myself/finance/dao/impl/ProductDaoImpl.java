package com.myself.finance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myself.finance.dao.BaseDao;
import com.myself.finance.dao.IProductDao;
import com.myself.finance.entity.Product;
import com.myself.finance.mapper.IProductMapper;
import com.myself.finance.param.ProductQueryParam;

@Repository
public class ProductDaoImpl extends BaseDao<IProductMapper> implements IProductDao {

	public int save(Product param) {
		IProductMapper mapper = getMapper(IProductMapper.class);
		return mapper.save(param);
	}

	public int update(Product param) {
		IProductMapper mapper = getMapper(IProductMapper.class);
		return mapper.update(param);
	}

	public int delete(Product param) {
		IProductMapper mapper = getMapper(IProductMapper.class);
		return mapper.delete(param);
	}

	public Product getData(Product param) {
		IProductMapper mapper = getMapper(IProductMapper.class);
		return mapper.getData(param);
	}
	
	@Override
	public List<Product> query(ProductQueryParam param, int start, int end) {
		IProductMapper mapper = getMapper(IProductMapper.class);
		return mapper.query(param, start, end);
	}

	@Override
	public int count(ProductQueryParam param) {
		IProductMapper mapper = getMapper(IProductMapper.class);
		return mapper.count(param);
	}

}

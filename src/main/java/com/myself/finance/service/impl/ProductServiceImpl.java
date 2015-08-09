package com.myself.finance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.finance.dao.ProductDao;
import com.myself.finance.entity.Product;
import com.myself.finance.page.IPage;
import com.myself.finance.page.Page;
import com.myself.finance.page.Pager;
import com.myself.finance.param.ProductQueryParam;
import com.myself.finance.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public int save(Product param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Product param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Product param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Product getData(Product param) {
		return productDao.getData(param);
	}

	public List<Product> list(Page<ProductQueryParam> param) {
		return productDao.list(param);
	}

	@Override
	public IPage<Product> query(ProductQueryParam param) {
		IPage<Product> pager = null;
		int count = productDao.count(param);
		if (count > 0) {
			int page = (param.getPage() <= 0) ? 1 : param.getPage();
			int start = (page - 1) * param.getLength();
			int end = param.getLength();
			List<Product> list = productDao.query(param, start, end);
			pager = new Pager<Product>(list, count, page, end);
		} else {
			pager = new Pager<Product>(new ArrayList<Product>(), 0, 1, 1);
		}
		return pager;
	}

}

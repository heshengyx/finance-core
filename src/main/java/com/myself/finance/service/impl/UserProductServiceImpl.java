package com.myself.finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.finance.dao.UserProductDao;
import com.myself.finance.data.UserProductData;
import com.myself.finance.page.IPage;
import com.myself.finance.param.UserProductQueryParam;
import com.myself.finance.service.UserProductService;

@Service("userProductService")
public class UserProductServiceImpl implements UserProductService {

	@Autowired
	private UserProductDao userProductDao;

	@Override
	public IPage<UserProductData> query(UserProductQueryParam param) {
		// TODO Auto-generated method stub
		return null;
	}

}

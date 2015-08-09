package com.myself.finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.finance.dao.IUserProductDao;
import com.myself.finance.data.UserProductData;
import com.myself.finance.page.IPage;
import com.myself.finance.param.UserProductQueryParam;
import com.myself.finance.service.IUserProductService;

@Service("userProductService")
public class UserProductServiceImpl implements IUserProductService {

	@Autowired
	private IUserProductDao userProductDao;

	@Override
	public IPage<UserProductData> query(UserProductQueryParam param) {
		// TODO Auto-generated method stub
		return null;
	}

}

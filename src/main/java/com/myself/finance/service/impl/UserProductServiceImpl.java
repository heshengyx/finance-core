package com.myself.finance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.finance.dao.IUserProductDao;
import com.myself.finance.data.UserProductData;
import com.myself.finance.page.IPage;
import com.myself.finance.page.Page;
import com.myself.finance.param.UserProductQueryParam;
import com.myself.finance.service.IUserProductService;

@Service("userProductService")
public class UserProductServiceImpl implements IUserProductService {

	@Autowired
	private IUserProductDao userProductDao;

	@Override
	public IPage<UserProductData> query(UserProductQueryParam param) {
		IPage<UserProductData> page = null;
		int count = userProductDao.count(param);
		if (count > 0) {
			int pageNo = (param.getPage() <= 0) ? 1 : param.getPage();
			int start = (pageNo - 1) * param.getLength();
			int end = param.getLength();
			List<UserProductData> list = userProductDao.query(param, start, end);
			page = new Page<UserProductData>(list, count, pageNo, end);
		} else {
			page = new Page<UserProductData>(new ArrayList<UserProductData>(), 0, 1, 1);
		}
		return page;
	}

}

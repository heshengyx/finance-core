package com.myself.finance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myself.finance.dao.BaseDao;
import com.myself.finance.dao.IUserProductDao;
import com.myself.finance.data.UserProductData;
import com.myself.finance.mapper.IUserProductMapper;
import com.myself.finance.page.Page;
import com.myself.finance.param.UserProductQueryParam;

@Repository
public class UserProductDaoImpl extends BaseDao<IUserProductMapper> implements IUserProductDao {

	public List<UserProductData> list(Page<UserProductQueryParam> param) {
		IUserProductMapper mapper = getMapper(IUserProductMapper.class);
		return mapper.query(param);
	}

	@Override
	public List<UserProductData> query(UserProductQueryParam param, int start,
			int end) {
		// TODO Auto-generated method stub
		return null;
	}

}

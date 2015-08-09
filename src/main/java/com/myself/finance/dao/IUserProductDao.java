package com.myself.finance.dao;

import java.util.List;

import com.myself.finance.data.UserProductData;
import com.myself.finance.param.UserProductQueryParam;

public interface IUserProductDao {

	int count(UserProductQueryParam param);
	List<UserProductData> query(UserProductQueryParam param, int start, int end);
}

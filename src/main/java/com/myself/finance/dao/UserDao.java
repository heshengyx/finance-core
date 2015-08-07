package com.myself.finance.dao;

import java.util.List;

import com.myself.finance.entity.User;
import com.myself.finance.param.UserQueryParam;

public interface UserDao {

	int save(User param);
	int update(User param);
	int delete(User param);
	User getData(User param);
	
	int count(UserQueryParam param);
	List<User> query(UserQueryParam param, int start, int end);
}

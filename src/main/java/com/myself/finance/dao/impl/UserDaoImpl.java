package com.myself.finance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myself.finance.dao.BaseDao;
import com.myself.finance.dao.IUserDao;
import com.myself.finance.entity.User;
import com.myself.finance.mapper.IUserMapper;
import com.myself.finance.param.UserQueryParam;

@Repository
public class UserDaoImpl extends BaseDao<IUserMapper> implements IUserDao {

	public int save(User param) {
		IUserMapper mapper = getMapper(IUserMapper.class);
		return mapper.save(param);
	}

	public int update(User param) {
		IUserMapper mapper = getMapper(IUserMapper.class);
		return mapper.update(param);
	}

	public int delete(User param) {
		IUserMapper mapper = getMapper(IUserMapper.class);
		return mapper.delete(param);
	}

	public User getData(User param) {
		IUserMapper mapper = getMapper(IUserMapper.class);
		return mapper.getData(param);
	}

	@Override
	public List<User> query(UserQueryParam param, int start, int end) {
		IUserMapper mapper = getMapper(IUserMapper.class);
		return mapper.query(param, start, end);
	}

	@Override
	public int count(UserQueryParam param) {
		IUserMapper mapper = getMapper(IUserMapper.class);
		return mapper.count(param);
	}
}

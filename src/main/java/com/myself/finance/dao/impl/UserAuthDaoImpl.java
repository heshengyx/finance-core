package com.myself.finance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myself.finance.dao.BaseDao;
import com.myself.finance.dao.IUserAuthDao;
import com.myself.finance.entity.UserAuth;
import com.myself.finance.mapper.IUserAuthMapper;
import com.myself.finance.param.UserAuthQueryParam;

@Repository
public class UserAuthDaoImpl extends BaseDao<IUserAuthMapper> implements IUserAuthDao {

	public List<UserAuth> list(UserAuthQueryParam param) {
		IUserAuthMapper mapper = getMapper(IUserAuthMapper.class);
		return mapper.list(param);
	}

}

package com.myself.finance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.finance.dao.IUserAuthDao;
import com.myself.finance.entity.UserAuth;
import com.myself.finance.param.UserAuthQueryParam;
import com.myself.finance.service.IUserAuthService;

@Service("userAuthService")
public class UserAuthServiceImpl implements IUserAuthService {

	@Autowired
	private IUserAuthDao userAuthDao;
	
	public List<UserAuth> list(UserAuthQueryParam param) {
		return userAuthDao.list(param);
	}

}

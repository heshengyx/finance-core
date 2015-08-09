package com.myself.finance.dao;

import java.util.List;

import com.myself.finance.entity.UserAuth;
import com.myself.finance.param.UserAuthQueryParam;

public interface IUserAuthDao {

	List<UserAuth> list(UserAuthQueryParam param);
}

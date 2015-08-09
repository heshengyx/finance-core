package com.myself.finance.mapper;

import java.util.List;

import com.myself.finance.entity.UserAuth;
import com.myself.finance.param.UserAuthQueryParam;

public interface IUserAuthMapper {

	List<UserAuth> list(UserAuthQueryParam param);
}

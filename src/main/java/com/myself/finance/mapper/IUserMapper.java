package com.myself.finance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myself.finance.entity.User;
import com.myself.finance.param.UserQueryParam;

public interface IUserMapper {

	int save(User param);
	int update(@Param("param") User param);
	int delete(@Param("param") User param);
	User getData(@Param("param") User param);
	User getDataByUsername(@Param("param") User param);

	int count(@Param("param") UserQueryParam param);
	List<User> query(@Param("param") UserQueryParam param,
			@Param("start") int start, @Param("end") int end);
}

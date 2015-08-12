package com.myself.finance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myself.finance.entity.Role;
import com.myself.finance.param.RoleQueryParam;

public interface IRoleMapper {

	int save(@Param("param") Role param);

	int update(@Param("param") Role param);

	int delete(@Param("param") Role param);

	Role getData(@Param("param") Role param);

	int count(@Param("param") RoleQueryParam param);

	List<Role> query(@Param("param") RoleQueryParam param,
			@Param("start") int start, @Param("end") int end);

	List<Role> queryRolesByUserId(String userId);
}

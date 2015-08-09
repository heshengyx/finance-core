package com.myself.finance.dao;

import java.util.List;

import com.myself.finance.entity.Role;
import com.myself.finance.param.RoleQueryParam;

public interface IRoleDao {

	int save(Role param);
	int update(Role param);
	int delete(Role param);
	Role getData(Role param);
	
	int count(RoleQueryParam param);
	List<Role> query(RoleQueryParam param, int start, int end);
	List<Role> queryRolesByUserId(String userId);
}

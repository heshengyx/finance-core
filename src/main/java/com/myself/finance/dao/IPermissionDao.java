package com.myself.finance.dao;

import java.util.List;

import com.myself.finance.entity.Permission;
import com.myself.finance.entity.RolePermission;
import com.myself.finance.param.PermissionQueryParam;

public interface IPermissionDao {

	int save(Permission param);
	int update(Permission param);
	int delete(Permission param);
	Permission getData(Permission param);
	
	List<Permission> list(PermissionQueryParam param);
	int count(PermissionQueryParam param);
	List<Permission> query(PermissionQueryParam param, int start, int end);
	List<Permission> queryPermissionsByRoleId(String roleId);
	List<Permission> queryPermissions();
	
	int saveRolePermissions(List<RolePermission> param);
	List<RolePermission> queryRolePermissionsByRoleId(String roleId);
	int deleteRolePermissionsByRoleId(String roleId);
}

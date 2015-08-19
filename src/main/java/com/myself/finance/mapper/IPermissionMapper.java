package com.myself.finance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myself.finance.entity.Permission;
import com.myself.finance.entity.RolePermission;
import com.myself.finance.param.PermissionQueryParam;

public interface IPermissionMapper {

	int save(@Param("param") Permission param);

	int update(@Param("param") Permission param);

	int delete(@Param("param") Permission param);

	Permission getData(@Param("param") Permission param);

	List<Permission> list(@Param("param") PermissionQueryParam param);
	
	List<Permission> tree(@Param("param") PermissionQueryParam param);
	
	int count(@Param("param") PermissionQueryParam param);

	List<Permission> query(@Param("param") PermissionQueryParam param,
			@Param("start") int start, @Param("end") int end);
	List<Permission> queryPermissionsByRoleId(String roleId);
	
	int saveRolePermissions(@Param("param") List<RolePermission> param);
	List<RolePermission> queryRolePermissionsByRoleId(@Param("roleId") String roleId);
	int deleteRolePermissionsByRoleId(@Param("roleId") String roleId);
	
}

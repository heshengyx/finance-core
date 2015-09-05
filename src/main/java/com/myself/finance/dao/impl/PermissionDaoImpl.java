package com.myself.finance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myself.finance.dao.BaseDao;
import com.myself.finance.dao.IPermissionDao;
import com.myself.finance.entity.Permission;
import com.myself.finance.entity.RolePermission;
import com.myself.finance.mapper.IPermissionMapper;
import com.myself.finance.param.PermissionQueryParam;

@Repository
public class PermissionDaoImpl extends BaseDao<IPermissionMapper> implements IPermissionDao {

	public List<Permission> queryPermissionsByRoleId(String roleId) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.queryPermissionsByRoleId(roleId);
	}

	public List<Permission> list(PermissionQueryParam param) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.list(param);
	}

	public int save(Permission param) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.save(param);
	}

	public int update(Permission param) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.update(param);
	}

	public int delete(Permission param) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.delete(param);
	}

	public Permission getData(Permission param) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.getData(param);
	}

	@Override
	public List<Permission> query(PermissionQueryParam param, int start, int end) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.query(param, start, end);
	}

	@Override
	public int count(PermissionQueryParam param) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.count(param);
	}

	@Override
	public List<RolePermission> queryRolePermissionsByRoleId(String roleId) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.queryRolePermissionsByRoleId(roleId);
	}

	@Override
	public int deleteRolePermissionsByRoleId(String roleId) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.deleteRolePermissionsByRoleId(roleId);
	}

	@Override
	public int saveRolePermissions(List<RolePermission> param) {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.saveRolePermissions(param);
	}

	@Override
	public List<Permission> queryPermissions() {
		IPermissionMapper mapper = getMapper(IPermissionMapper.class);
		return mapper.queryPermissions();
	}

}

package com.myself.finance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.common.utils.UIDGeneratorUtil;
import com.myself.finance.dao.IPermissionDao;
import com.myself.finance.data.PermissionTreeData;
import com.myself.finance.entity.Permission;
import com.myself.finance.entity.RolePermission;
import com.myself.finance.page.IPage;
import com.myself.finance.page.Page;
import com.myself.finance.param.PermissionQueryParam;
import com.myself.finance.param.RolePermissionParam;
import com.myself.finance.service.IPermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	private IPermissionDao permissionDao;
	
	public List<Permission> queryPermissionsByRoleId(String roleId) {
		return permissionDao.queryPermissionsByRoleId(roleId);
	}

	public int save(Permission param) {
		param.setId(UIDGeneratorUtil.getUID());
		param.setStatus("1");
		param.setCreateTime(new Date());
		return permissionDao.save(param);
	}

	public int update(Permission param) {
		return permissionDao.update(param);
	}

	public int delete(Permission param) {
		return permissionDao.delete(param);
	}

	public Permission getData(Permission param) {
		return permissionDao.getData(param);
	}

	public List<Permission> list(PermissionQueryParam param) {
		List<Permission> datas = new ArrayList<Permission>();
		List<Permission> permissions = permissionDao.list(param);
		for (Permission permission : permissions) {
			datas.add(permission);
			param.setParentId(permission.getId());
			datas.addAll(permissionDao.list(param));
		}
		return datas;
	}

	@Override
	public IPage<Permission> query(PermissionQueryParam param) {
		IPage<Permission> page = null;
		int count = permissionDao.count(param);
		if (count > 0) {
			int pageNo = (param.getPage() <= 0) ? 1 : param.getPage();
			int start = (pageNo - 1) * param.getLength();
			int end = param.getLength();
			List<Permission> list = permissionDao.query(param, start, end);
			page = new Page<Permission>(list, count, pageNo, end);
		} else {
			page = new Page<Permission>(new ArrayList<Permission>(), 0, 1, 1);
		}
		return page;
	}

	@Override
	public List<PermissionTreeData> tree(PermissionQueryParam param) {
		List<Permission> datas = permissionDao.list(param);
		List<RolePermission> permissions = permissionDao.queryRolePermissionsByRoleId(param.getRoleId());
		StringBuffer rolePermissions = new StringBuffer("");
		for (RolePermission rolePermission : permissions) {
			rolePermissions.append(rolePermission.getPermissionId()).append(";");
		}
		
		List<PermissionTreeData> trees = new ArrayList<PermissionTreeData>();
		PermissionTreeData tree = null;
		int i = 0;
		for (Permission permission : datas) {
			tree = new PermissionTreeData();
			tree.setId(permission.getId());
			tree.setParentId((permission.getParentId() == null) ? "" : permission.getParentId());
			tree.setName(permission.getName());
			tree.setTag(permission.getTag());
			if (rolePermissions.toString().indexOf(permission.getId()) != -1) {
				tree.setChecked(true);
			}
			if (i == 0 && permission.getParentId() == null) {
				tree.setOpen(true);
				i++;
			}
			trees.add(tree);
		}
		return trees;
	}

	@Override
	public void saveRolePermissions(RolePermissionParam param) {
		permissionDao.deleteRolePermissionsByRoleId(param.getRoleId());
		List<RolePermission> datas = new ArrayList<RolePermission>();
		RolePermission rolePermission = null;
		String[] permissionIds = param.getPermissionId();
		for (String permissionId : permissionIds) {
			rolePermission = new RolePermission();
			rolePermission.setRoleId(param.getRoleId());
			rolePermission.setPermissionId(permissionId);
			datas.add(rolePermission);
		}
		permissionDao.saveRolePermissions(datas);
	}
}

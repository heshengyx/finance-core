package com.myself.finance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.common.utils.UIDGeneratorUtil;
import com.myself.finance.dao.IRoleDao;
import com.myself.finance.entity.Role;
import com.myself.finance.page.IPage;
import com.myself.finance.page.Page;
import com.myself.finance.param.RoleQueryParam;
import com.myself.finance.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;
	
	public List<Role> queryRolesByUserId(String userId) {
		return roleDao.queryRolesByUserId(userId);
	}

	public int save(Role param) {
		param.setId(UIDGeneratorUtil.getUID());
		param.setStatus("1");
		param.setCreateTime(new Date());
		return roleDao.save(param);
	}

	public int update(Role param) {
		param.setUpdateTime(new Date());
		return roleDao.update(param);
	}

	public int delete(Role param) {
		return roleDao.delete(param);
	}

	public Role getData(Role param) {
		return roleDao.getData(param);
	}

	@Override
	public IPage<Role> query(RoleQueryParam param) {
		IPage<Role> page = null;
		int count = roleDao.count(param);
		if (count > 0) {
			int pageNo = (param.getPage() <= 0) ? 1 : param.getPage();
			int start = (pageNo - 1) * param.getLength();
			int end = param.getLength();
			List<Role> list = roleDao.query(param, start, end);
			page = new Page<Role>(list, count, pageNo, end);
		} else {
			page = new Page<Role>(new ArrayList<Role>(), 0, 1, 1);
		}
		return page;
	}

}

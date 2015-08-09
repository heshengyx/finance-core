package com.myself.finance.dao.impl;

import org.springframework.stereotype.Repository;

import com.myself.finance.dao.IAccountDao;
import com.myself.finance.dao.BaseDao;
import com.myself.finance.entity.Account;
import com.myself.finance.mapper.IAccountMapper;

@Repository
public class AccountDaoImpl extends BaseDao<IAccountMapper> implements IAccountDao {

	public int save(Account param) {
		IAccountMapper mapper = getMapper(IAccountMapper.class);
		return mapper.save(param);
	}

	public int update(Account param) {
		IAccountMapper mapper = getMapper(IAccountMapper.class);
		return mapper.update(param);
	}

	public int delete(Account param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Account getData(Account param) {
		IAccountMapper mapper = getMapper(IAccountMapper.class);
		return mapper.getData(param);
	}
}

package com.myself.finance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myself.finance.dao.BaseDao;
import com.myself.finance.dao.IAccountTradeDao;
import com.myself.finance.entity.AccountTrade;
import com.myself.finance.mapper.IAccountTradeMapper;
import com.myself.finance.param.AccountTradeQueryParam;

@Repository
public class AccountTradeDaoImpl extends BaseDao<IAccountTradeMapper> implements IAccountTradeDao {

	public int save(AccountTrade param) {
		IAccountTradeMapper mapper = getMapper(IAccountTradeMapper.class);
		return mapper.save(param);
	}

	public int update(AccountTrade param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(AccountTrade param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public AccountTrade getData(AccountTrade param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(AccountTradeQueryParam param) {
		IAccountTradeMapper mapper = getMapper(IAccountTradeMapper.class);
		return mapper.count(param);
	}

	@Override
	public List<AccountTrade> query(AccountTradeQueryParam param, int start,
			int end) {
		IAccountTradeMapper mapper = getMapper(IAccountTradeMapper.class);
		return mapper.query(param, start, end);
	}

}

package com.myself.finance.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.common.utils.UIDGeneratorUtil;
import com.myself.finance.dao.IAccountTradeDao;
import com.myself.finance.entity.AccountTrade;
import com.myself.finance.page.IPage;
import com.myself.finance.param.AccountTradeQueryParam;
import com.myself.finance.service.IAccountTradeService;

@Service("accountTradeService")
public class AccountTradeServiceImpl implements IAccountTradeService {

	private final static Logger logger = LoggerFactory
			.getLogger(AccountTradeServiceImpl.class);
	
	@Autowired
	private IAccountTradeDao accountDetailDao;
	
	public void save(AccountTrade param) {
		param.setId(UIDGeneratorUtil.getUID());
		param.setStatus("1");
		param.setCreateTime(new Date());
		accountDetailDao.save(param);
	}

	public void update(AccountTrade param) {
		
	}

	public void delete(AccountTrade param) {
		
	}

	public AccountTrade getData(AccountTrade param) {
		return null;
	}

	@Override
	public IPage<AccountTrade> query(AccountTradeQueryParam param) {
		// TODO Auto-generated method stub
		return null;
	}
}

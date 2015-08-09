package com.myself.finance.dao;

import java.util.List;

import com.myself.finance.entity.AccountTrade;
import com.myself.finance.param.AccountTradeQueryParam;

public interface IAccountTradeDao {

	int save(AccountTrade param);
	int update(AccountTrade param);
	int delete(AccountTrade param);
	AccountTrade getData(AccountTrade param);
	
	int count(AccountTradeQueryParam param);
	List<AccountTrade> query(AccountTradeQueryParam param, int start, int end);
}

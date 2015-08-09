package com.myself.finance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myself.finance.entity.AccountTrade;
import com.myself.finance.param.AccountTradeQueryParam;

public interface IAccountTradeMapper {

	int save(AccountTrade param);

	int update(AccountTrade param);

	int delete(AccountTrade param);

	AccountTrade getData(AccountTrade param);

	int count(@Param("param") AccountTradeQueryParam param);

	List<AccountTrade> query(@Param("param") AccountTradeQueryParam param,
			@Param("start") int start, @Param("end") int end);
}

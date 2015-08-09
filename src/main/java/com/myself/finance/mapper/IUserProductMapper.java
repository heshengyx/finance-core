package com.myself.finance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myself.finance.data.UserProductData;
import com.myself.finance.param.UserProductQueryParam;

public interface IUserProductMapper {

	int count(@Param("param") UserProductQueryParam param);

	List<UserProductData> query(@Param("param") UserProductQueryParam param,
			@Param("start") int start, @Param("end") int end);
}

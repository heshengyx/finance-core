package com.myself.finance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myself.common.exception.ServiceException;
import com.myself.common.utils.UIDGeneratorUtil;
import com.myself.finance.dao.IAccountDao;
import com.myself.finance.dao.IUserDao;
import com.myself.finance.entity.Account;
import com.myself.finance.entity.User;
import com.myself.finance.page.IPage;
import com.myself.finance.page.Page;
import com.myself.finance.param.UserParam;
import com.myself.finance.param.UserQueryParam;
import com.myself.finance.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	private final static Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IAccountDao accountDao;

	public int save(User param) {
		param.setId(UIDGeneratorUtil.getUID());
		param.setCreateTime(new Date());
		return userDao.save(param);
	}

	@Transactional
	public void register(UserParam param, String captcha) {
		if (!captcha.equals(param.getCaptcha())) {
			logger.info("验证码输入不正确，输入验证码={}，图片验证码={}", new Object[]{param.getCaptcha(), captcha});
			throw new ServiceException("验证码输入不正确");
		}
		
		User user = new User();
		try {
			PropertyUtils.copyProperties(user, param);
		} catch (Exception e) {
			logger.error("User属性复制出错", e);
			throw new ServiceException("用户注册失败");
		}
		user.setAccount(user.getUsername());
		try {
			save(user);
		} catch (Exception e) {
			logger.error("用户注册失败", e);
			throw new ServiceException("用户注册失败");
		}
		Account account = new Account();
		account.setId(UIDGeneratorUtil.getUID());
		account.setUserId(user.getId());
		account.setBalance(0L);
		account.setStatus("1");
		account.setCreateTime(new Date());
		
		try {
			accountDao.save(account);
		} catch (Exception e) {
			logger.error("账户开通失败", e);
			throw new ServiceException("用户注册失败");
		}
		
	}

	public int update(User param) {
		param.setUpdateTime(new Date());
		return userDao.update(param);
	}

	public int delete(User param) {
		return userDao.delete(param);
	}

	@Override
	public User getData(User param) {
		return userDao.getData(param);
	}

	@Override
	public IPage<User> query(UserQueryParam param) {
		IPage<User> page = null;
		int count = userDao.count(param);
		if (count > 0) {
			int pageNo = (param.getPage() <= 0) ? 1 : param.getPage();
			int start = (pageNo - 1) * param.getLength();
			int end = param.getLength();
			List<User> list = userDao.query(param, start, end);
			page = new Page<User>(list, count, pageNo, end);
		} else {
			page = new Page<User>(new ArrayList<User>(), 0, 1, 1);
		}
		return page;
	}

	@Override
	public User getDataByUsername(User param) {
		return userDao.getDataByUsername(param);
	}
}
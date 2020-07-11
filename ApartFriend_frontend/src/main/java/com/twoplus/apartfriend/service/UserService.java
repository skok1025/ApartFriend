package com.twoplus.apartfriend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twoplus.apartfriend.provider.UserProvider;
import com.twoplus.apartfriend.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserProvider userProvider;

	public Integer inserUser(UserVO userVo) {
		return userProvider.insertUser(userVo);
	}

}

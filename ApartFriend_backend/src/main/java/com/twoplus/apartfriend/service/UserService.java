package com.twoplus.apartfriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twoplus.apartfriend.mapper.UserMapper;
import com.twoplus.apartfriend.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserVO getAuthUser(UserVO userVo) {
		return userMapper.selectAuthUser(userVo);
	}

	public int insertUser(UserVO userVo) {
		return userMapper.insertUser(userVo);
	}
	
}

package com.twoplus.apartfriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twoplus.apartfriend.mapper.UserMapper;
import com.twoplus.apartfriend.vo.UserVO;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	//모든 유저정보 get
	public List<UserVO> getUserList() throws Exception {
		return userMapper.getUserList();
	}
	
	public void addUser(UserVO userVO) throws Exception {
		userMapper.addUser(userVO);
	}
	
}

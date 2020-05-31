package com.twoplus.apartfriend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.twoplus.apartfriend.vo.UserVO;

//@Mapper
public interface UserMapper {

	//모든 유저정보 get
	public List<UserVO> getUserList();
	
	public void addUser(UserVO userVO);
	
}

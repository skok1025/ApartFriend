package com.twoplus.apartfriend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.twoplus.apartfriend.vo.UserVO;

@Mapper
public interface UserMapper {

	public UserVO selectAuthUser(UserVO userVo);

	public int insertUser(UserVO userVo);
	
}

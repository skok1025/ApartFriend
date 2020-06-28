package com.twoplus.apartfriend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.twoplus.apartfriend.vo.UserVO;

@Mapper
public interface UserMapper {

	//모든 유저정보 get
	public List<UserVO> getUserList();
	
	//회원가입
	public int addUser(UserVO userVO);
	
	//회원수정
	public int updateUser(UserVO userVO);
	
	//회원삭제
	public int deleteUser(UserVO userVO);
	
}

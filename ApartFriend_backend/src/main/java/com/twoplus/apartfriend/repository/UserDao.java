package com.twoplus.apartfriend.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.twoplus.apartfriend.vo.UserVO;

@Repository
public class UserDao {


	@Autowired
	private SqlSession sqlSession;

	public UserVO selectAuthUser(UserVO userVo) {
		return sqlSession.selectOne("user.selectAuthUser",userVo);
	}
	
	
	
}
